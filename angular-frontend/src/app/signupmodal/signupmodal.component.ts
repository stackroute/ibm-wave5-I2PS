import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signupmodal',
  templateUrl: './signupmodal.component.html',
  styleUrls: ['./signupmodal.component.css']
})
export class SignupmodalComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  onSubmitServiceProvider() {
    this.router.navigateByUrl("/serviceprovider");
  }

  onSubmitInnovator() {
    this.router.navigateByUrl("/innovatorprofile");
  }

}
