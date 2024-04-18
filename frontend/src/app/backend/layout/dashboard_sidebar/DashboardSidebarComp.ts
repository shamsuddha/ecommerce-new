import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
 selector: 'DashboardSidebarComp',
 templateUrl: './DashboardSidebarComp.html',
 styleUrls: ['./DashboardSidebarComp.scss'],
 standalone: true,
 imports: [CommonModule, RouterOutlet],
 providers: [],
})
export class DashboardSidebarComp implements OnInit {

  constructor() { }

  ngOnInit(): void { }
}