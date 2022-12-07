import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegistrationComponent } from './registration/registration/registration.component';
import { RailwayDashBoardComponent } from './railway-dash-board/railway-dash-board.component';
import { HttpClientModule } from '@angular/common/http';
import { AdminDataComponent } from './admin-data/admin-data.component';
import { RailwaystatusComponent } from './railwaystatus/railwaystatus.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { DatePipe } from '@angular/common';
import { BookTicketComponent } from './book-ticket/book-ticket.component';


// import { MatCardModule } from '@angular/material'


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    RailwayDashBoardComponent,
    AdminDataComponent,
    RailwaystatusComponent,
    UpdateUserComponent,
    BookTicketComponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,//for routing
    FormsModule,//for two way bindig
    ReactiveFormsModule, 
    HttpClientModule,
    // MatCardModule
  ],
  exports:[
    LoginComponent,
    RegistrationComponent,
    RailwayDashBoardComponent,
    AdminDataComponent
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
