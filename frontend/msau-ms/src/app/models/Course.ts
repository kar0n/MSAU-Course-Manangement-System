export interface Course {
    courseId: number;
    name: string;
    description: string;
    prerequisites: string;
    skills: string;
    location: string;
    createdOn:  Date;
    modifiedOn: Date;
    creatorId: Number;
    
}