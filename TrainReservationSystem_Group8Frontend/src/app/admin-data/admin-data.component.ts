import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { User } from '../model/user';
import { CommonService } from '../shared/common.service';

@Component({
  selector: 'app-admin-data',
  templateUrl: './admin-data.component.html',
  styleUrls: ['./admin-data.component.css']
})
export class AdminDataComponent implements OnInit {

  constructor(public commonserviceService:CommonService,private rt:Router) { }
   user:User[];

  ngOnInit(): void {
    this.commonserviceService.getAllUserData().subscribe((data:User[])=>{
      this.user=data; })
  }

  editData(user:User){
    console.log(user)
    this.commonserviceService.user=Object.assign({},user);
    this.rt.navigate(["updateUser"])
    // window.location.reload()
  }
  deleteData(userId:number){
    console.log(userId)
    this.commonserviceService.deleteUserData(userId).subscribe();
    window.location.reload();
  }
}
