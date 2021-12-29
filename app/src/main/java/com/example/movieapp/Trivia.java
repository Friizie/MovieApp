package com.example.movieapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// Trivia class, contains a list of Questions
public class Trivia {
    private ArrayList<Question> questions;
    private ArrayList<Question> selectedquestions; // by difficulty

    public Trivia() {
        this.questions = new ArrayList<>();
    }

    void addQuestion(Question q){
        questions.add(q);
    }

    void removeQuestion(int i) {
        questions.remove(i);
    }

    public ArrayList<Question> getSelectedQuestions() {
        return selectedquestions;
    }
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    void shuffleQuestions() {
        Collections.shuffle(this.questions);
    }
    void shuffleSelectedQuestions() {
        Collections.shuffle(this.selectedquestions);
    }


//    ArrayList<Question> nQuestions(int n) {
//        ArrayList<Question> nq = new ArrayList<>();
//        int j=0;
//        for (int i = 0; i < n; i++) {
//            if(i >= questions.size())
//                j=0;
//            nq.add(questions.get(j++));
//        }
//        return nq;
//    }

    void questionsByDifficulty(int dif) {
        ArrayList<Question> list = new ArrayList<>();
        for (Question q : questions) {
            if(q.getDifficulty() == dif) {
                list.add(q);
            }
        }
        selectedquestions = list;
    }


    private ArrayList<String> setAnswers(String one, String two, String three, String four){
        return new ArrayList<>(Arrays.asList(one,two,three,four));
    }

    void initQuestions() {
        ArrayList<String> answers;

        answers = setAnswers("Answer 1","Answer 2","Answer 3","Answer 4");
        addQuestion(new Question("Question?",
                answers,1,1,5,R.drawable.qmark));
        // question // list // correct // 0,1,2 poeni // sllika

        // Hard
        answers = setAnswers("The Wolf Of Wall Street","Ride along","Sudden impact","The day the earth stood still");
        addQuestion(new Question("\"Go ahead, make my day.\"",
                answers,3,2,5,0));

        answers = setAnswers("The good, the bad, the ugly","Little women","12 Angry men","Gone with the wind");
        addQuestion(new Question("\"Frankly, my dear, I don't give a damn.\"",
                answers,4,2,5,0));

        answers = setAnswers("On the waterfront","Gran torino","Rocky","Spider-Man");
        addQuestion(new Question("\"You don't understand! I coulda had class. I coulda been a contender. I could've been somebody, instead of a bum, which is what I am.\"",
                answers,1,2,5,0));

        answers = setAnswers("The Wizard of Oz","Gone with the wind","The Maze Runner","King Kong");
        addQuestion(new Question("\"Toto, I've got a feeling we're not in Kansas anymore.\"",
                answers,1,2,5,0));

        answers = setAnswers("Star Wars","Loser","Casablanca","Peaky blinders");
        addQuestion(new Question("\"Here's looking at you, kid.\"",
                answers,3,2,5,0));

        answers = setAnswers("The girl next door","Sunset Boulevard","Aloha","Gangster Squad");
        addQuestion(new Question("\"All right, Mr. DeMille, I'm ready for my close-up.\"",
                answers,2,2,5,0));

        answers = setAnswers("Gangster Squad","All About Eve","Ocean's thirteen","Drive");
        addQuestion(new Question("\"You talking to God Mitch, so you might as well swear to me\"",
                answers,1,2,5,0));

        answers = setAnswers("Spider-Man","All About Eve","Mission: Impossible","The old guard");
        addQuestion(new Question("\"Fasten your seatbelts. It's going to be a bumpy night.\"",
                answers,2,2,5,0));

        answers = setAnswers("Taxi 3","Star Wars","Madagascar","Hand Luke");
        addQuestion(new Question("\"What we've got here is failure to communicate.\"",
                answers,4,2,5,0));

        answers = setAnswers("E.T The Extra-Terrestrial","The Maltese Falcon","Home Alone","The Shining");
        addQuestion(new Question("\"The stuff that dreams are made of.\"",
                answers,2,2,5,0));

        answers = setAnswers("E.T The Extra-Terrestrial","Citizen Kane","White Heat","White House Down");
        addQuestion(new Question("\"E.T. phone home.\"",
                answers,1,2,5,0));

        answers = setAnswers("Aloha","American Sniper","In the Heat of The Night","IT");
        addQuestion(new Question("\"They call me Mister Tibbs!\"",
                answers,3,2,5,0));

        answers = setAnswers("Titanic","Joker","White Heat","Die Hard");
        addQuestion(new Question("\"Made it, Ma! Top of the world!\"",
                answers,3,2,5,0));

        answers = setAnswers("Network","Dirty Harry","Breaking bad","Casablanca");
        addQuestion(new Question("\"I'm as mad as hell, and I'm not going to take this anymore!\"",
                answers,1,2,5,0));

        answers = setAnswers("Sunset Boulevard","Titanic","The Prestige","The Lord of the Rings");
        addQuestion(new Question("\"I am big! It's the pictures that got small.\"",
                answers,1,2,5,0));

        answers = setAnswers("The Amazing Spider-Man","She Done Him Wrong","Batman Begins","Batman Returns");
        addQuestion(new Question("\"Why don't you come up sometime and see me?\"",
                answers,2,2,5,0));

        answers = setAnswers("Battleship","Casablanca","Mr. and Mrs Smith","The Hobbit");
        addQuestion(new Question("\"Play it, Sam. Play 'As Time Goes By.'\"",
                answers,2,2,5,0));

        answers = setAnswers("Ride Along","The Nice Guys","Dark Shadows","The Pride of the Yankees");
        addQuestion(new Question("\"Today, I consider myself the luckiest man on the face of the earth.\"",
                answers,4,2,5,0));

        answers = setAnswers("Field of Dreams","The Graduate","Home Alone 3","Mama");
        addQuestion(new Question("\"If you build it, he will come.\"",
                answers,1,2,5,0));

        answers = setAnswers("Some Like it Hot","Now, Voyager","Superman Returns","Shane");
        addQuestion(new Question("\"Oh, Jerry, don't let's ask for the moon. We have the stars.\"",
                answers,2,2,5,0));


        answers = setAnswers("Aloha","1917","Jerry Maguire","Annie Hall");
        addQuestion(new Question("\"You had me at? hello.?\"",
                answers,3,2,5,0));


        answers = setAnswers("2012","The Killing Joke","Inception","Annie Hall");
        addQuestion(new Question("\"La-dee-da, la-dee-da.\"",
                answers,4,2,5,0));

        answers = setAnswers("Lord Of War","Bruno","Wall Street","The Great Gatsby");
        addQuestion(new Question("\"Greed, for lack of a better word, is good.\"",
                answers,1,2,5,0));


        answers = setAnswers("Scarface","Beyond the Forest","Gone With the Wind","The Do Over");
        addQuestion(new Question("\"As God is my witness, I'll never be hungry again.\" ",
                answers,3,2,5,0));

        answers = setAnswers("Loser","Sons of The Desert","Ted","Naked Gun");
        addQuestion(new Question("\"Well, here's another nice mess you've gotten me into!\"",
                answers,2,2,5,0));

        answers = setAnswers("Kung Fu Panda","Straight Outta Compton","Destination Wedding","The Adventures of Sherlock Holmes");
        addQuestion(new Question("\"Elementary, my dear Watson.\"",
                answers,4,2,5,0));

        answers = setAnswers("Little Caesar","Inception","Mr. No","Doctor Sleep");
        addQuestion(new Question("\"Mother of mercy, is this the end of Rico?\"",
                answers,1,2,5,0));

        answers = setAnswers("Chinatown","Sing 2","No time to Die","Rain Man");
        addQuestion(new Question("\"Forget it, Jake, it's Chinatown.\"",
                answers,1,2,5,0));

        answers = setAnswers("Rain Man","Hangover","A Streetcar Named Desire","Thor: The Dark World");
        addQuestion(new Question("\"I have always depended on the kindness of strangers.\"",
                answers,3,2,5,0));

        answers = setAnswers("Rocky II","Airplane","Shrek 2","Funny Girl");
        addQuestion(new Question("Striker: \"Surely you can't be serious.\"\nRumack: \"I am serious?and don't call me Shirley.\"",
                answers,2,2,5,0));

        answers = setAnswers("Spectre","Dog Day Afternoon","King Kong","Godzilla");
        addQuestion(new Question("\"Oh, no, it wasn't the airplanes. It was Beauty killed the Beast.\"",
                answers,3,2,5,0));

        answers = setAnswers("Goldfinger","On Golden Pond","Harry Potter and the Prisoner of Azkaban","No Time to Die");
        addQuestion(new Question("\"Listen to me, mister. You're my knight in shining armor. Don't you forget it. \n" +
                "You're going to get back on that horse, and \n" +
                "I'm going to be right behind you, holding on tight, \n" +
                "and away we're gonna go, go, go!\"",
                answers,2,2,5,0));

        answers = setAnswers("Knut Rockne All American","The Matrix","Kung Fu Fury","The Naught Nineties");
        addQuestion(new Question("\"Tell 'em to go out there with all they got and win just one for the Gipper.\"",
                answers,1,2,5,0));

        answers = setAnswers("Auntie Meme","Spider-Man","Gladiator","Caddyshack");
        addQuestion(new Question("\"Cinderella story. Outta nowhere. A former\n" +
                "greenskeeper, now, about to become the Masters champion.\n" +
                "It looks like a mirac...It's in\n" +
                "the hole! It's in the hole! It's in the hole!\"",
                answers,4,2,5,0));

        answers = setAnswers("Titanic","Top Gun","Dead Poets Society","Caddyshack");
        addQuestion(new Question("\"Carpe diem. Seize the day, boys. Make your lives extraordinary.\"",
                answers,3,2,5,0));

        answers = setAnswers("Yankee Doodle Dandy","47 Ronin","TENET","TORQUE");
        addQuestion(new Question("\"My mother thanks you. My father thanks you. My sister thanks you. And I thank you.\"",
                answers,1,2,5,0));

        answers = setAnswers("Se7en","Requiem for a dream","The Wizard of Oz","Finding Nemo");
        addQuestion(new Question("\"I'll get you, my pretty, and your little dog, too!\"",
                answers,3,2,5,0));


        answers = setAnswers("Finding Dory","Broke Back","Spider-Man: Homecoming","The Dark Knight");
        addQuestion(new Question("\"I wish I knew how to quit you\"",
                answers,2,2,5,0));

        answers = setAnswers("There Will be Blood","The Good, the bad, the Ugly","Mission: Impossible","Casino Royal");
        addQuestion(new Question("\"I drink your milkshake\"",
                answers,1,2,5,0));

        answers = setAnswers("Child's Play","The Social Network","Die Another Day","The Witch");
        addQuestion(new Question("\"Wouldst thou like to live deliciously?\" ",
                answers,4,2,5,0));

        answers = setAnswers("Parasite","The Bicycle Thieves","Shutter Island","Thor Ragnarok");
        addQuestion(new Question("\"Why should I kill myself worrying when I'll end up \n" +
                "just as dead?\"",
                answers,2,2,5,0));

        answers = setAnswers("The Silence of the Lambs","Parasite","Robin Hood: Prince of Thieves","Back to the future");
        addQuestion(new Question("\"You know what kind of plan never fails? No plan. \n" +
                "No plan at all. You know why? Because life cannot \n" +
                "be planned.\"",
                answers,2,2,5,0));

        answers = setAnswers("The Wedding Ringer","Requiem for a Dream","47 Ronin","Aloha");
        addQuestion(new Question("\"Ah, it's not the same. They don't need me. I like the way I feel. I like \n" +
                "thinking about the red dress and the television and you and your father. Now when \n" +
                "I get the sun, I smile.\"",
                answers,2,2,5,0));


        answers = setAnswers("Norbit","Rush Hour","Zodiac","The Usual Suspects");
        addQuestion(new Question("\"The greatest trick the devil ever pulled was to convince the world he didn't exist\"",
                answers,4,2,5,0));

        answers = setAnswers("Good Morning Vietnam","Blade Runner","Tootsie","When Harry Met Sally");
        addQuestion(new Question("\"Gooooooooooooooooooooood moring Vietnaaaam!\"",
                answers,1,2,5,0));

        answers = setAnswers("Blade Runner 2049","Who Framed Roger Rabbit","Project Almanac","You've Got Mail");
        addQuestion(new Question("\"Iam not bad iam just drawn this way\"",
                answers,2,2,5,0));

        answers = setAnswers("Blended","Murder Mystery","The Karate Kid","Body of Lies");
        addQuestion(new Question("\" Wax on right hand, Wax off left hand, Wax on, Wax off\"",
                answers,3,2,5,0));

        answers = setAnswers("Troy","Gladiator","Spartacus","Bem Hur");
        addQuestion(new Question("\"My name is Maximus Decimus Meridius, Commander of the Armies of the North, General of the \n" +
                "Felix Legions, loyal servant to the true emperor, Marcus Aurelius. Father to a murdered son, \n" +
                "husband to a murdered wife. And I will have my vengeance, in this life or the next.\"",
                answers,2,2,5,0));

        answers = setAnswers("Frankenstein","Zombieland","Mad Max: Fury Road","In Time");
        addQuestion(new Question("",
                answers,3,2,5,0));

        answers = setAnswers("The Jazz Singer","Finding Nemo","Pulp Fiction","Whiplash");
        addQuestion(new Question("\"I was there to push people beyond what's expected of them\"",
                answers,4,2,5,0));

        answers = setAnswers("Whiplash","Good Will Hunting","Inception","Enemy Of The State");
        addQuestion(new Question("\"There are no two words in the English language more harmful than \"good job\".\"",
                answers,1,2,5,0));

        answers = setAnswers("Dog Day Afternoon","Ben-Hur","Leon: The Professional","Saving Private Ryan");
        addQuestion(new Question("\"Its when you really start to fear death that you learn to appreciate life.\"",
                answers,3,2,5,0));


        answers = setAnswers("Home Alone","Leon: The Professional","Project Power","Dirty Dancing");
        addQuestion(new Question("\"Is life always this hard, or is it just when you're a kid\"\n" +
                "\"Always\"",
                answers,2,2,5,0));

        answers = setAnswers("The Lion King","Cars","Sing 2","Spy");
        addQuestion(new Question("\"I'am surrounded by idiots\"",
                answers,1,2,5,0));

        answers = setAnswers("Mad Max","Joker","Blow","American Psycho");
        addQuestion(new Question("\"I believe in taking care of myself, in \n" +
                "a balanced diet, in a rigorous exercise routine.\n" +
                "In the morning, if my face is a little puffy, I'll \n" +
                "put on an  icepack while doing my stomach crunches.\n" +
                "I can do a thousand now. After I remove the icepack, \n" +
                "I use a deep-pore cleanser lotion. In The shower...\"",
                answers,4,2,5,0));
        


        // Easy


    }



}
