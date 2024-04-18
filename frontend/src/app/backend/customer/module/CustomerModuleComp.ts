import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { DashboardHeaderComp } from './dashboard_header/DashboardHeaderComp';
import { DashboardFooterComp } from './dashboard_footer/DashboardFooterComp';
import { DashboardSidebarComp } from './dashboard_sidebar/DashboardSidebarComp';

@Component({
 selector: 'CustomerModuleComp',
 templateUrl: './CustomerModuleComp.html',
 standalone: true,
 imports: [CommonModule, RouterOutlet, DashboardHeaderComp, DashboardFooterComp, DashboardSidebarComp],
 providers: [],
})
export class CustomerModuleComp implements OnInit {

  constructor() { }

  ngOnInit(): void { }

}