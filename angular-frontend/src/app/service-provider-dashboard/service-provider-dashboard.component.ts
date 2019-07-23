import { Component, OnInit } from '@angular/core';
import { RegistrationServiceService } from '../registration-service.service';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from '../login.service';
import { RecentIdeasService } from '../recent-ideas.service';
import { MatDialog } from '@angular/material';
import { ApplySuccessComponent } from '../apply-success/apply-success.component';

@Component({
  selector: 'app-service-provider-dashboard',
  templateUrl: './service-provider-dashboard.component.html',
  styleUrls: ['./service-provider-dashboard.component.scss']
})
export class ServiceProviderDashboardComponent implements OnInit {
  recommendedIdeasApplied: any;

  constructor(private loginService:LoginService, private router:Router, private route:ActivatedRoute, private recentideas:RecentIdeasService, private dialog: MatDialog) { }

  recommendedIdeas:any=[];
  arrayOfIdeas:any=[];
  status: boolean;
  allIdeas:any=[];

  ngOnInit() {
    this.getRecommendation();
    this.getRecommendationByApplied();
  }

  getRecommendation():void
  {
    const emailId=this.route.snapshot.paramMap.get('sendEmailId');
    console.log("in service-provider..get by email"+emailId);
    this.loginService.getRecommendations(emailId).subscribe((data:any)=>{
      console.log("data fetched.."+ data);
      this.recommendedIdeas=data;
      this.arrayOfIdeas=data;

      this.arrayOfIdeas.map(i=>{
        i.status=true;
        this.allIdeas.push(i);
       

      })
     
     

      console.log("after getting back from service",this.recommendedIdeas);
    });
  }

  goToProfile():void{
    const emailId=this.route.snapshot.paramMap.get('sendEmailId');
    console.log(emailId);
    this.router.navigateByUrl('/serviceProfile/'+emailId);
  }

  applyForAnIdea(value)
  {
  
    console.log(value.ideaName);
    const emailId=this.route.snapshot.paramMap.get('sendEmailId');
    console.log(emailId);
    if(emailId==null)
    {
      console.log("displaying null")
      // this.router.navigateByUrl('/login');
    }
    else{
      
  
        this.arrayOfIdeas=this.arrayOfIdeas.map(e => {
          console.log("hmmm",value.ideaName+e.ideaName,"...........",value.status)
          if(e.ideaName==value.ideaName)
          {
    
          value.status=false;
          }
        
          return e;
          
        })
        
      }
      
      this.recentideas.sendToInnovator(value.ideaName,emailId);
  //create success modal
    }

goToAllIdeas(){
  const emailId=this.route.snapshot.paramMap.get('sendEmailId');
  this.router.navigateByUrl('/allIdeas/'+emailId);


}

getRecommendationByApplied():void
{
  const emailId=this.route.snapshot.paramMap.get('sendEmailId');
  console.log("in service-provider..get by email"+emailId);
  this.loginService.getRecommendationsByApplied(emailId).subscribe((data:any)=>{
    console.log("data fetched.."+ data);
    this.recommendedIdeasApplied=data;
    this.arrayOfIdeas=data;

    this.arrayOfIdeas.map(i=>{
      i.status=true;
      this.allIdeas.push(i);
     

    })
   
   

    console.log("after getting back from service",this.recommendedIdeasApplied);
  });
}
}