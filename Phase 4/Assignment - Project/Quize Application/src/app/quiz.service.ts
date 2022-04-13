import { Injectable } from '@angular/core';
import { Quiz } from './quiz.model';

@Injectable({
  providedIn: 'root'
})
export class QuizService {
  quizzes: Quiz[]=[
    {
      question : 'Which of the following statement is correct for AngularJS? ',
      answer:[
        {option: 'AngularJS is an HTML framework' , correct : false},
        {option: 'AngularJS is a Java framework ' , correct : false},
        {option: 'AngularJS is a JavaScript framework ' , correct : true},
        {option: 'AngularJS is a SQL framework' , correct :false }
      ]
    },

    
{
    question : 'On which of the Architectural pattern AngularJS is based?',
    answer:[
      {option: 'Observer Pattern ' , correct : false},
      {option: 'Decorator pattern ' , correct : false},
      {option: 'MVC Architecture pattern ' , correct : false},
      {option: 'MVVM Architectural pattern ' , correct :true }
    ]
  },
{
  question : 'AngularJS is perfect for?',
  answer:[
    {option: 'SPAs ' , correct : true},
    {option: 'MPAs ' , correct : false},
    {option: 'DPAs ' , correct : false},
    {option: 'CPAs ' , correct :false }
  ]
},
{
question : 'Which of the following is the correct syntax for writing AngularJS expressions?',
answer:[
  {option: '(expression) ' , correct : false},
  {option: '{{expression}} ' , correct : true},
  {option: '{{{expression}}} ' , correct : false},
  {option: '[expression] ' , correct :false }

]
},
{
question : 'Do AngularJS provide reusable components?',
answer:[
  {option: 'Yes ' , correct : true},
  {option: 'No ' , correct : false}

]
},
{
question : 'Which of the following directive is used to bind the application data to the HTML view in AngularJS?',
answer:[
  {option: 'ng-app directive ' , correct : false},
  {option: 'ng-model directive ' , correct : false},
  {option: 'ng-bind directive ' , correct : true},
  {option: 'ng-init directive ' , correct :false }

]
},
{
question : 'Which of the following statement is true about the lowercase filter?',
answer:[
  {option: 'The lowercase filter converts a text to lower case text. ' , correct : true},
  {option: 'The lowercase filter is a function that takes text as input. ' , correct : false},
  {option: 'Both of the above. ' , correct : false},
  {option: 'None of the above. ' , correct :false }

]
},
{
question : 'Which of the following is an advantage of AngularJS?',
answer:[
  {option: 'AngularJS code is unit testable. ' , correct : false},
  {option: 'AngularJS provides reusable components. ' , correct : false},
  {option: 'AngularJS uses dependency injection and makes use of separation of concerns. ' , correct : false},
  {option: 'All of the above. ' , correct :true }

]
},
{
question : 'Which of the following is used to share data between controller and view in AngularJS?',
answer:[
  {option: 'using Model ' , correct : false},
  {option: 'using services ' , correct : true},
  {option: 'using factory ' , correct : false},
  {option: 'using $scope ' , correct :false }

]
},
]
  
  constructor() { }
  getQuizzes()
  {
    return this.quizzes;
  }

}
