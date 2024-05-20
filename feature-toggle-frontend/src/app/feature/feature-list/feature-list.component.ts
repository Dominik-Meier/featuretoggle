import { Component, OnInit } from '@angular/core';
import { FeatureService } from '../feature.service';
import { Feature } from '../feature';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-feature-list',
  standalone: true,
  imports: [NgFor],
  templateUrl: './feature-list.component.html'
})
export class FeatureListComponent implements OnInit {
  currentFeatures: Feature[];

  constructor(private featureService: FeatureService) {}

  ngOnInit(): void {
      this.featureService.getFeatures().subscribe((f: Feature[]) => {
        this.currentFeatures = f;
      })
  }

}
