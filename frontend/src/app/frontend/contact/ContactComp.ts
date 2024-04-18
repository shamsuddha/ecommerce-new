import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
 selector: 'ContactComp',
 templateUrl: './ContactComp.html',
 styleUrls: ['./ContactComp.scss'],
 standalone: true,
 imports: [CommonModule, RouterOutlet],
 providers: [],
})
export class ContactComp implements OnInit {

  constructor() { }

  ngOnInit(): void { }
}