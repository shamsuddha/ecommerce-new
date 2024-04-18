import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
 selector: 'DashboardFooterComp',
 templateUrl: './DashboardFooterComp.html',
 styleUrls: ['./DashboardFooterComp.scss'],
 standalone: true,
 imports: [CommonModule, RouterOutlet],
 providers: [],
})
export class DashboardFooterComp implements OnInit {

  constructor() { }

  ngOnInit(): void { }
}