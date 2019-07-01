import { Component, OnInit } from '@angular/core';
import { CardServiceService } from '../card-service.service';
import { Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-card-details',
  templateUrl: './card-details.component.html',
  styleUrls: ['./card-details.component.css']
})
export class CardDetailsComponent implements OnInit {
  arrayOfIdeas = [];
  data;
  constructor(private cardService: CardServiceService, private router: Router, private route:ActivatedRoute) { }

  ngOnInit() {
    this.getIdeas();
  }


  getIdeas(): void {
  
  const id = this.route.snapshot.paramMap.get('id');
    console.log("????? "+id);
     this.cardService.getIdeaDetails(id).subscribe(data => {
  
      this.arrayOfIdeas=data;
      console.log("coming " +this.arrayOfIdeas)

     
  });



   
  }

  onClose() {
    this.router.navigateByUrl('/landingpage');
  }
}

// 
