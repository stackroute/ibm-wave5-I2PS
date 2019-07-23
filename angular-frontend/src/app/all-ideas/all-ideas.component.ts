import { Component, OnInit } from '@angular/core';
import { RecentIdeasService } from '../recent-ideas.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-all-ideas',
  templateUrl: './all-ideas.component.html',
  styleUrls: ['./all-ideas.component.scss']
})
export class AllIdeasComponent implements OnInit {

  constructor(private recentideas: RecentIdeasService ,private router: Router, private route:ActivatedRoute) { }
  arrayOfIdeas:any=[];
  status: boolean;
  allIdeas:any=[];

id;
  ngOnInit() {
    this.recentideas.getRecentIdeas().subscribe(data=>
    {
      console.log(data);
      this.arrayOfIdeas=data;

      this.arrayOfIdeas.map(i=>{
        i.status=true;
        this.allIdeas.push(i);
       

      })
     
    })

}

search(value)
{
  console.log(value);
  this.router.navigateByUrl('/search/'+value);


}

applyForAnIdea(value)
{

  console.log(value.title);
  const emailId=this.route.snapshot.paramMap.get('emailId');
  console.log(emailId);
  if(emailId==null)
  {
    console.log("displaying null")
    this.router.navigateByUrl('/login');
  }
  else{
    

      this.arrayOfIdeas=this.arrayOfIdeas.map(e => {
        console.log("hmmm",value.title+e.title,"...........",value.status)
        if(e.title==value.title)
        {
  
        value.status=false;
        }
      
        return e;
        
      })
      
    }
    
    this.recentideas.sendToInnovator(value.title,emailId);
//create success modal
  }
}
