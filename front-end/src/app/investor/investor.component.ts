import { Component, OnInit } from '@angular/core';
import { InvestorService } from "../../dataService/investor.service";

@Component({
  selector: 'app-investor',
  templateUrl: './investor.component.html',
  styleUrls: ['./investor.component.scss']
})
export class InvestorComponent implements OnInit {

  public gainsData = [];
  public totalInvestmentData:any = "";
  public monthlyInvestmentData = [];
  public domainBreakUpData = [];

  constructor(private _investorService: InvestorService) { }

  ngOnInit() {
    this.getInvestorPortfolioData();
  }

  getInvestorPortfolioData() {
    this._investorService.getInvestorPortfolioData().subscribe(
      data => {
        console.log("data =>", data);
        this.gainsData = data.investorGainsData;
        this.totalInvestmentData = data.investorTotalInvestment;
        this.monthlyInvestmentData = data.investorBreakupData;
        this.domainBreakUpData = data.investorDomainData;
      }
    );
  }

  onSelect($event, key) {
    
  }

}
