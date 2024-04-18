import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
 selector: 'DashboardHeaderComp',
 templateUrl: './DashboardHeaderComp.html',
 styleUrls: ['./DashboardHeaderComp.scss'],
 standalone: true,
 imports: [CommonModule, RouterOutlet],
 providers: [],
})
export class DashboardHeaderComp implements OnInit {

  constructor() { }

  ngOnInit(): void { }
}