import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeatureListComponent } from './feature-list.component';
import { FeatureService } from '../feature.service';
import { of } from 'rxjs';

describe('FeatureListComponent', () => {
  let component: FeatureListComponent;
  let fixture: ComponentFixture<FeatureListComponent>;

  beforeEach(async () => {
    let mockService = jasmine.createSpyObj(FeatureService, ['getFeatures']);
    mockService.getFeatures.and.returnValue(of([]));

    await TestBed.configureTestingModule({
      providers: [{provide: FeatureService, useValue: mockService}],
      imports: [FeatureListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FeatureListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
