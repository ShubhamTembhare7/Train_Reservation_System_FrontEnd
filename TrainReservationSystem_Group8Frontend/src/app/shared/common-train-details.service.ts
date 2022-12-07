
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TicketReservationModel } from '../model/ticket-reservation-model';
import { User } from '../model/user';



@Injectable({
  providedIn: 'root'
})
export class CommonTrainDetailsService {

  // addTrain:string="http://10.9.17.210:8082/getTrainDetails";//tamanna
   checkTrain:string="http://localhost:8082/checkTrainDetails"
   getTrainDetail:string="http://localhost:8082/getTrainDetails"
   url:string="http://localhost:8082/checkTrainDetails"

  constructor(private http:HttpClient) { }

  

  train:TicketReservationModel={
    trainId: 0,
    journeyType: '',
    from: '',
    to: '',
    departDate: '',
    returnDate: '',
    adultPassenger: 0,
    childrenPassenger: 0,
    travelClass: '',
    trainName: ''
  }
  

  checkTrainAvailability(train:TicketReservationModel):Observable<TicketReservationModel>{
    console.log(train)
    // console.log("hhhhhhhhhhhhhh")
    return this.http.post<any>(`${this.checkTrain}`,train);
  }

  // checkTrainAvailability(train:TicketReservationModel):Observable<TicketReservationModel>{
  //   // console.log(train)
  //   console.log("hhhhhhhhhhhhhh")
  //   return this.http.post<any>(this.checkTrain,train);
  // }

  
  getAllUserData():Observable<TicketReservationModel[]>{
    return this.http.get<TicketReservationModel[]>(this.url);
  }


  public saveUser(user: TicketReservationModel): Observable<any> {
    const url = 'http://localhost:8082/checkTrainDetails';
    return this.http.post<any>(url, user);
  }

  public saveUserTyped(user: TicketReservationModel): Observable<any> {
    const url = 'https://reqres.in/api/users';
    return this.http.post<TicketReservationModel>(url, user);
}
  

}
