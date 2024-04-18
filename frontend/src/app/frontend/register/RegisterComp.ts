import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
 selector: 'RegisterComp',
 templateUrl: './RegisterComp.html',
 styleUrls: ['./RegisterComp.scss'],
 standalone: true,
 imports: [CommonModule, RouterOutlet],
 providers: [],
})
export class RegisterComp implements OnInit {

  constructor() { }

  ngOnInit(): void { }
}