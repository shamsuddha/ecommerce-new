import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
 selector: 'HomeComp',
 templateUrl: './HomeComp.html',
 styleUrls: ['./HomeComp.scss'],
 standalone: true,
 imports: [CommonModule, RouterOutlet],
 providers: [],
})
export class HomeComp implements OnInit {

  constructor() { }

  ngOnInit(): void { }
}