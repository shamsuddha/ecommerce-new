import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
 selector: 'RoleComp',
 templateUrl: './RoleComp.html',
 styleUrls: ['./RoleComp.scss'],
 standalone: true,
 imports: [CommonModule, RouterOutlet],
 providers: [],
})
export class RoleComp implements OnInit {

  constructor() { }

  ngOnInit(): void { }
}