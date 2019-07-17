import { Component, OnInit } from '@angular/core';
import { RecentIdeasService } from '../recent-ideas.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-idea-detail',
  templateUrl: './idea-detail.component.html',
  styleUrls: ['./idea-detail.component.scss']
})
export class IdeaDetailComponent implements OnInit {
ideaDetail:any=[];
appliedSP:any=[];
status:boolean=false;
  constructor(private recentideas: RecentIdeasService ,private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getDetails();
    this.getAppliedServiceProvider();
  }

  getDetails():any{
    const title=this.route.snapshot.paramMap.get('title');
    this.recentideas.getIdeaDetails(title).subscribe((data:any)=>{
      console.log("data fetched.."+ data);
      this.ideaDetail=data;
      console.log("after getting back from service",this.ideaDetail);
      console.log("list is ",this.ideaDetail.serviceProviders)
    });
  }

  getAppliedServiceProvider():any{
    const title=this.route.snapshot.paramMap.get('title');
    console.log("get title"+title);
    this.recentideas.getAppliedServiceProviders(title).subscribe((data:any)=>
    {
      this.appliedSP=data;
      // console.log(this.appliedSP[0]+"heyyyy");
      // console.log("applied people"+this.appliedSP.name);


    })
  }

  onApprove(value){
    console.log(value);
    this.status=true;
    const title=this.route.snapshot.paramMap.get('title');
    console.log(value, this.status, title)
    this.recentideas.approveOrRejectSP(title,value,this.status);
    console.log("done");
    
    this.ideaDetail.serviceProviders.push(value);
    console.log("list is ",this.ideaDetail.serviceProviders)

  }

  onReject(emailId){
    console.log(emailId);
    this.status=false;
 let index=this.appliedSP.indexOf(emailId);
 console.log(index);
 this.appliedSP.splice(index,1);
 console.log(this.appliedSP);
  }



}
