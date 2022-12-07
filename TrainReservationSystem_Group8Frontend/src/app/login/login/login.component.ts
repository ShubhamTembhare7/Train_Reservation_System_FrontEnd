import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder,FormControl,FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { empty } from 'rxjs';
import { User } from 'src/app/model/user';
import { CommonService } from 'src/app/shared/common.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginform: FormGroup; //form builder

   user=new User();
  //  user1:User[];
   
  msg='';
  constructor(public rt:Router, public fb: FormBuilder,public commonService:CommonService) { }

  ngOnInit(): void {
    this.loginform=this.fb.group({
      
      userName:['',[Validators.required]],
      password:['', [Validators.required]]
    });
  }

  log(){
    if(this.loginform.get('userName').value=="aaa" && this.loginform.get('password').value==4321){
      this.rt.navigate(["admin"])
    }
    else{
      this.commonService.userLoginCheck(this.user).subscribe(
        data =>{
          console.log(this.user)
          this.rt.navigate(['/rail'])
        },
        error =>
        {
         //alert("invalid username and password")
         this.msg="Invalid username and password!!!"
        }
      );
    } 

   
  }

  register(){
   this.rt.navigate(["register"])
  }

}
