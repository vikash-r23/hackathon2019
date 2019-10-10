import { Component, OnInit } from '@angular/core';
import { IdeasService } from "../../dataService/ideas.service";
import { SignInService } from 'src/dataService/sign-in.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ideas',
  templateUrl: './ideas.component.html',
  styleUrls: ['./ideas.component.scss']
})
export class IdeasComponent implements OnInit {

  ideaDetailsTitle = "";
  ideaDetailsData = "";
  addIdeaTitle = '';
  addIdeaModal = '';
  ideasData = [];
  userDetails;

  isAdminHidden = true;
  isInvestorHidden = true;
  isIdeaPitcherHidden = true;

  constructor(private _ideasService: IdeasService, private _signinService: SignInService, private router: Router) { }

  ngOnInit() {
    this.getIdeaData();
    this.userDetails = this._signinService.userDetails;
    console.log(this.userDetails);
    this.setLinks(this.userDetails);
  }

  setLinks(userDetails) {
    switch (userDetails.userType) {
      case 'INVESTOR': {
        this.isInvestorHidden = false;
        this.isAdminHidden = this.isIdeaPitcherHidden = true;
      }

        break;

      case 'IDEA_PITCHER': {
        this.isIdeaPitcherHidden = false;
        this.isAdminHidden = this.isInvestorHidden = true;
      }
        break;

      case 'VIEWER': {
        this.isAdminHidden = false;
        this.isIdeaPitcherHidden = this.isInvestorHidden = true;
      }
        break;

      default:
        break;
    }
  }

  knowMoreClick(data) {
    console.log('data =>', data);
    this.ideaDetailsData = data.details;
    this.ideaDetailsTitle = data.name;
  }

  addIdea() {
    this.addIdeaModal = '';
    this.addIdeaTitle = 'Add Idea';
  }

  signMeOut() {
    localStorage.clear();
    this.router.navigate(['/signIn']);
  }

  getIdeaData() {
    this._ideasService.getIdeasData().subscribe(
      data => {
        this.ideasData = data.ideasData;
      }
    );
  }
}
