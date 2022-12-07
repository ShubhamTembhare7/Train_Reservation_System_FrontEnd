import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { TicketReservationModel } from '../model/ticket-reservation-model';
import { CommonTrainDetailsService } from '../shared/common-train-details.service';
import { DatePipe } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { any, object } from 'underscore';

@Component({
  selector: 'app-railway-dash-board',
  templateUrl: './railway-dash-board.component.html',
  styleUrls: ['./railway-dash-board.component.css']
})
export class RailwayDashBoardComponent implements OnInit {

  trainDetail: FormGroup;
  train = new TicketReservationModel();
  trainSearchResult: TicketReservationModel[];
  

  msg = ""

  constructor(public commonService: CommonTrainDetailsService, private rt: Router, public fb: FormBuilder, private http: HttpClient) { }
  
  
  ngOnInit(): void {


    this.trainDetail = this.fb.group({
      trainId: 0,
     // journeyType: '',
      from: '',
      to: '',
      departDate: '',
      returnDate: '',
      //adultPassenger: 0,
      //childrenPassenger: 0,
      travelClass: ''

    });
  }



  trainStatus() {
    
    this.commonService.getAllUserData().subscribe(data=>{
      this.trainSearchResult=data;
    
       this.rt.navigate(["trainStatus"]);
    })




    // this.commonService.checkTrainAvailability(this.train).subscribe(
    //   data => {
    //     // alert("success")
    //     // console.log(data);
    //     this.mydata = data;
    //     this.mydata.forEach((a: any) => {
    //       Object.assign(a,{quentiy:1,total:a.from});
    //       console.log(a)

    //     });

    //     this.rt.navigate(["trainStatus"]);
    //   },
    //   error => {
    //     alert("wrong input")
    //     this.msg = "wrong input"
    //   });

    

  }


}

