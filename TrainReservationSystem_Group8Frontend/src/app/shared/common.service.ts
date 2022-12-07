import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  // url:string="http://localhost:3000/User"; //db.json
  // url1:string="http://localhost:9091/rail/user";
  addUser:string="http://localhost:8082/userRegistration";
  // url:string="http://10.9.17.210:8082/userRegistration"; //tamanna
  loginCheck:string="http://localhost:8082/userLoginCheck";
  adminPage:string="http://localhost:8082/getAllUserData";
  deleteUser:string="http://localhost:8082/deleteUserDetails";
  updateUser:string="http://localhost:8082/updateUser"
  // url2:string="http://localhost:8082/getUserDetails/{userName}/{password}";
  
  
  
  
  constructor(private http:HttpClient) { }

  user:User={
    id: 0,
    firstName: '',
    lastName: '',
    email: '',
    userName: '',
    password: '',
    mobileNumber: 0,
    dateOfBirth: '',
    gender: '',
    
  }


  // addUserRegistration(user:User):Observable<User>{
  //   console.log(user)
  //   return this.http.post<any>(`${this.url}`,user);
  // }

  addUserRegistration(user:User):Observable<User>{
    console.log(user)
    return this.http.post<any>(this.addUser,user);
  }

  userLoginCheck(user:User):Observable<User>{
    return this.http.post<any>(`${this.loginCheck}`,user);
  }


  getAllUserData():Observable<User[]>{
    return this.http.get<User[]>(this.adminPage);
  }

  deleteUserData(id:number){
    return this.http.delete(this.deleteUser+"/"+id);  
  }

  // postData1(user:User):Observable<User>{
  //   return this.http.post<any>(this.url5,user);
  // }
  
  updateData(user:User):Observable<User>{
    return this.http.put<User>(this.updateUser+"/"+user.id,user);
  }
  

  

}
