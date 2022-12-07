import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TicketReservationModel } from '../model/ticket-reservation-model';
import { CommonTrainDetailsService } from '../shared/common-train-details.service';

@Component({
  selector: 'app-railwaystatus',
  templateUrl: './railwaystatus.component.html',
  styleUrls: ['./railwaystatus.component.css']
})
export class RailwaystatusComponent implements OnInit {

  getTrain: RailwaystatusComponent;
  constructor(public commonService: CommonTrainDetailsService, private rt: Router) { }

   train: TicketReservationModel[];
  //train=new TicketReservationModel();
  ngOnInit(): void {
    
   this.commonService.getAllUserData().subscribe((data:TicketReservationModel[])=>{
    this.train=data; 
  });
  }

  ticketBooking(){
    this.rt.navigate(["ticketBook"])
  }

  


}
