import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CourseService } from 'src/app/services/courseService/course.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  user: any;
  public locations: any;
  public skills: any;
  
  constructor(
    private router: Router,
    private courseService: CourseService,
    ) { }

  ngOnInit(): void {
    
    this.courseService.countLocation().subscribe((res)=>{
      this.locations = res;
    });

    this.courseService.countSkills().subscribe((res)=>{
      this.skills = res;
    });
  }  

  // visible data booleans
  showXAxis = true;
  showYAxis = true;
  gradient = false;
  showLegend = true;
  showXAxisLabel = true;
  xAxisLabel = 'Locations';
  showYAxisLabel = true;
  yAxisLabel = 'Count';
  timeline = true;


  // color scheme for the bars
  colorScheme = {
    domain: ['#9370DB', '#87CEFA', '#FA8072', '#FF7F50', '#90EE90', '#9370DB']
  };

  trend1 = true;
  trend2 = false;

  public activeTrend(mode: string): void {
    if (mode === 'trend1') {
      this.trend1 = true;
      this.trend2 = false;
   
    }
    if (mode === 'trend2') {
    
      this.trend1 = false;
      this.trend2 = true;
    }
  }

  onShow(event : any) {
    console.log(event);
  }

}



