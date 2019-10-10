import { Component, OnInit } from '@angular/core';
import { AdminService } from "../../dataService/admin.service";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  earningsData = []; 
  monthlyEarningsData = [];
  totalEarningsData:any = "";

  companyBreakUpData = [];
  companyEarnings:any = "";
  comapanyInvestment = [];

  dropDownData = [];

  constructor(private _adminService: AdminService) { }

  ngOnInit() {
    this.getAdminTotalData();
    this.getAdminDropDownData();
  }

  getAdminTotalData() {
    this._adminService.getAdminTotalData().subscribe(
      data => {
        console.log("data =>", data);
        this.monthlyEarningsData = data.adminMonthlyData;
        this.totalEarningsData = data.adminTotalEarnings;
        this.earningsData = data.adminEarningsData;
      }
    );
  }

  getAdminDropDownData() {
    this._adminService.getAdminDropDownData().subscribe(
      data => {
        console.log("data 1=>", data);
        this.dropDownData = data.adminIdeaPitcherData;
      }
    );
  }

  onDropDownChange($event) {
    
  }
  onSelect($event, key) {

  }

}
