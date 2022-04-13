export class Quiz
{
  question :string | undefined;
  answer : { option: string; correct: boolean; }[] | undefined;
}
