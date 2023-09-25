package com.example.nafasivibao.models

class Product{
    var name:String=""
    var company:String=""
    var location:String=""
    var time:String=""
    var responsibilities:String=""
    var skills:String=""
    var docs:String=""
    var deadline:String=""
    var id:String=""

    constructor(name:String,company:String,location:String, time:String,responsibilities:String,skills:String,docs:String,deadline:String, id:String){
        this.name=name
        this.company=company
        this.location=location
        this.time=time
        this.responsibilities=responsibilities
        this.skills=skills
        this.docs=docs
        this.deadline=deadline
        this.id=id

    }
    constructor()
}

