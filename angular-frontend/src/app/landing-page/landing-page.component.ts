import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CardServiceService } from '../card-service.service';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent implements OnInit {

  constructor(private cardService: CardServiceService,private router: Router) { }
  arrayOfIdeas:any=[];
id;
  ngOnInit() {
    this.cardService.getRecentIdeas().subscribe(data=>
    {
      console.log(data);
      this.arrayOfIdeas=data;

    })

    // onClick(){

    // }
  }

  onSubmitServiceProvider(serviceprovider) {
      this.router.navigateByUrl("/serviceprovider");
    }

    onSubmitInnovator(innovator) {
      this.router.navigateByUrl("/innovatorprofile");
    }

  signUp() {
    this.router.navigateByUrl("/serviceprovider");
    //this.router.navigateByUrl("/innovatorprofile");

  }
  signUpInnovator() {
    this.router.navigateByUrl("/innovatorprofile");
  }
}
