import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { DashboardHeaderComp } from './dashboard_header/DashboardHeaderComp';
import { DashboardFooterComp } from './dashboard_footer/DashboardFooterComp';
import { DashboardSidebarComp } from './dashboard_sidebar/DashboardSidebarComp';

@Component({
 selector: 'BackendLayoutComp',
 templateUrl: './BackendLayoutComp.html',
 standalone: true,
 imports: [CommonModule, RouterOutlet, DashboardHeaderComp, DashboardFooterComp, DashboardSidebarComp],
 providers: [],
})
export class BackendLayoutComp implements OnInit {

  constructor() { }

  ngOnInit(): void { }

}