import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BnNgIdleService } from 'bn-ng-idle';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AngularRoutingProject';

  constructor(private bnIdle: BnNgIdleService ,private rt:Router){}

  ngOnInit():void{
    this.bnIdle.startWatching(100000).subscribe((isTimedOut: boolean) => {

      if (isTimedOut) {
  
        console.log('session expired');
  
        alert("expired");
  
        this.rt.navigate(["login"]);
  
      }
  });
}

}
  

