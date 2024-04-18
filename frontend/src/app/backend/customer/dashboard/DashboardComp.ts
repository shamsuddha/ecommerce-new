import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
 selector: 'DashboardComp',
 templateUrl: './DashboardComp.html',
 styleUrls: ['./DashboardComp.scss'],
 standalone: true,
 imports: [CommonModule, RouterOutlet],
 providers: [],
})
export class DashboardComp implements OnInit {

  constructor() { }

  ngOnInit(): void { }
}