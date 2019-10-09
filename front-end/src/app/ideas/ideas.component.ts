import { Component, OnInit } from '@angular/core';
import { IdeasService } from "../../dataService/ideas.service";
import { SignInService } from 'src/dataService/sign-in.service';

@Component({
  selector: 'app-ideas',
  templateUrl: './ideas.component.html',
  styleUrls: ['./ideas.component.scss']
})
export class IdeasComponent implements OnInit {

  ideaDetailsTitle = "";
  ideaDetailsData = "";
  ideasData = [];
  userDetails={"userName":"raghu","userType":"Investor"};
  constructor(private _ideasService: IdeasService) { }

  ngOnInit() {
    this.getIdeaData();    
  }

  knowMoreClick(data) {
    console.log('data =>', data);
    this.ideaDetailsData = data.details;
    this.ideaDetailsTitle = data.name;
  }

  getIdeaData() {
    this._ideasService.getIdeasData().subscribe(
      data => {
        this.ideasData = data.ideasData;
      }
    );
  }
}
