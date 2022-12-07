import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDataComponent } from './admin-data/admin-data.component';
import { BookTicketComponent } from './book-ticket/book-ticket.component';
import { LoginComponent } from './login/login/login.component';
import { RailwayDashBoardComponent } from './railway-dash-board/railway-dash-board.component';
import { RailwaystatusComponent } from './railwaystatus/railwaystatus.component';
import { RegistrationComponent } from './registration/registration/registration.component';
import { UpdateUserComponent } from './update-user/update-user.component';

const routes: Routes = [
  {
    path:'',redirectTo:'login',pathMatch:'full'
  },
  {
    path:"login", component:LoginComponent
  },
  {
    path:"admin",component:AdminDataComponent
  },
  {
    path:"register",component:RegistrationComponent
  },
  {
    path:'rail', component:RailwayDashBoardComponent
  },
  {
    path:'trainStatus',component:RailwaystatusComponent
  },
  {
    path:'updateUser',component:UpdateUserComponent
  },
  {
    path:'ticketBook',component:BookTicketComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
