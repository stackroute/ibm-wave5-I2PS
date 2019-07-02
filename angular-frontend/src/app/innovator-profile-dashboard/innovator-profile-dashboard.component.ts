import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../registration.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-innovator-profile-dashboard',
  templateUrl: './innovator-profile-dashboard.component.html',
  styleUrls: ['./innovator-profile-dashboard.component.css']
})
export class InnovatorProfileDashboardComponent implements OnInit {

  constructor(private registrationService:RegistrationService,private router:Router) { }
  innovatorprofiledashboarddata =[];

  ngOnInit() {
    this.registrationService.getInnovatorProfile().subscribe(data=>
      {
        console.log(data);
        this.innovatorprofiledashboarddata=data;
      });
  }
 

}
