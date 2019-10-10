import { Component, OnInit } from '@angular/core';
import { StartUpService } from "../../dataService/start-up.service";

@Component({
  selector: 'app-start-ups',
  templateUrl: './start-ups.component.html',
  styleUrls: ['./start-ups.component.scss']
})
export class StartUpsComponent implements OnInit {

  constructor(private _startUpService: StartUpService) { }

  public investmentData = [];
  public breakupData = [];
  public areaBreakUpData = [];
  public interestsData = [];

  ngOnInit() {
    this.getStartUpPortfolioData();
  }

  getStartUpPortfolioData() {
    this._startUpService.getStartUpPortfolioData().subscribe(
      data => {
        console.log("data =>", data);
        this.areaBreakUpData = data.startUpAreaBreakUpData;
        this.interestsData = data.startUpInterestsData;
        this.breakupData = data.startUpBreakupData;
        this.investmentData = data.startUpInvestmentData;
      }
    );
  }

  // onSelect($event) {
  onSelect($event, key) {
    switch (key) {
      case 'investment': {

      }

        break;

      case 'breakup': {

      }
        break;

      case 'areaBreakUp': {

      }
        break;

      case 'interests': {

      }
        break;

      default:
        break;
    }
  }
}
