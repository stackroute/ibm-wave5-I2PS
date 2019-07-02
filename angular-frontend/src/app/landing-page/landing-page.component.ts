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

  login(){
    this.router.navigateByUrl('/serviceProviderdashboard')
  }

  onSubmitServiceProvider(serviceprovider) {
      this.router.navigateByUrl("/serviceprovider");
    }

    onSubmitInnovator(innovator) {
      this.router.navigateByUrl("/innovatorprofile");
    }

    routeDetails(data)  {
      console.log(data);
      this.id=data.id;
      console.log(this.id);
      this.router.navigateByUrl(`/cardDetail/`+data.id);
    }

}
