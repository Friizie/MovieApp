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

    // helper function for easier setup
    private ArrayList<String> setAnswers(String one, String two, String three, String four){
        return new ArrayList<>(Arrays.asList(one,two,three,four));
    }

    void initQuestions() {
        ArrayList<String> answers;

//        answers = setAnswers("Answer 1","Answer 2","Answer 3","Answer 4");
//        addQuestion(new Question("Question?", answers,1,1,5,R.drawable.qmark));
                              // question // list // correct // 0,1,2 poeni // slika

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
        addQuestion(new Question("\"I live, I die. I LIVE AGAIN!\"",
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


        // total Hard questions : 55



        // Easy

        answers = setAnswers("Penguins of Madagascar","Just go with it","SHREK","The Boys");
        addQuestion(new Question("\"Just smile and wave boys...smile and wave...\"",
                answers,1,0,5,0));

        answers = setAnswers("Ocean's Eleven","The Godfather","Scary Movie 1","The Dictator");
        addQuestion(new Question("\"I'm going to make him an offer he can't refuse.\"",
                answers,2,0,5,0));

        answers = setAnswers("Breaking bad","Star Wars","Dirty Harry","Bruno");
        addQuestion(new Question("\"May the Force be with you.\"",
                answers,2,0,5,0));

        answers = setAnswers("Apocalypse Now","Aloha","Taxi 3","Taxi Driver");
        addQuestion(new Question("\"You talking to me?\"",
                answers,4,0,5,0));

        answers = setAnswers("Die Hard","Terminator 2: Judgment Day","Apocalypse Now","Joker");
        addQuestion(new Question("\"I love the smell of napalm in the morning.\"",
                answers,3,0,5,0));

        answers = setAnswers("Love Story","Toy Story","The Room","The Story of Us");
        addQuestion(new Question("\"Love means never having to say you're sorry.\"",
                answers,1,0,5,0));

        answers = setAnswers("Casablanca","Love Story","The Dark Knight Rises","Taxi 1");
        addQuestion(new Question("\"Louis, I think this is the beginning of a beautiful friendship.\"",
                answers,1,0,5,0));

        answers = setAnswers("Hannibal","The Silence Of the Lambs","The Dark Knight","Joker");
        addQuestion(new Question("\"A census taker once tried to test me. I ate his liver with some fava beans and a nice Chianti.\"",
                answers,2,0,5,0));

        answers = setAnswers("Dr.No","Star Wars: Empire Strikes Back","The Story of Us","Casino");
        addQuestion(new Question("\"Bond. James Bond.\"",
                answers,1,0,5,0));

        answers = setAnswers("Tarzan","Home Alone","Casino Royal","The Wizard of Oz");
        addQuestion(new Question("\"There's no place like home.\" ",
                answers,4,0,5,0));

        answers = setAnswers("The Mummy","She Done Him Wrong","Jerry Maguire","The Bourne Supremacy");
        addQuestion(new Question("\"Show me the money!\"",
                answers,3,0,5,0));

        answers = setAnswers("Dirty Harry","Grand Hotel","Midnight Cowboy","Scarface");
        addQuestion(new Question("\"I'm walking here! I'm walking here!\"",
                answers,3,0,5,0));

        answers = setAnswers("Liar Liar","A Few Good Men","Fury","Die Another Day");
        addQuestion(new Question("\"You can't handle the truth!\"",
                answers,2,0,5,0));

        answers = setAnswers("Gone With the wind","The Shawshank Redemption","Leon the Professional","Rain Man");
        addQuestion(new Question("\"After all, tomorrow is another day!\"",
                answers,1,0,5,0));

        answers = setAnswers("Jaws","To Have and Have Not","To All the Boys I Loved","When Harry Met Sally");
        addQuestion(new Question("\"I'll have what she's having.\"",
                answers,4,0,5,0));

        answers = setAnswers("Jaws","Saw","The Notebook","How to Lose a Guy In 10 Days");
        addQuestion(new Question("\"You're gonna need a bigger boat.\"",
                answers,1,0,5,0));

        answers = setAnswers("The Terminator","Fast Five","The Graduate","The Terminator");
        addQuestion(new Question("\"I'll be back.\"",
                answers,4,0,5,0));

        answers = setAnswers("Fast Five","The Fast and Furious","Fast and Furious: Tokyo Drift","Furious 7");
        addQuestion(new Question("\"I don't have friends, I got family\"",
                answers,4,0,5,0));

        answers = setAnswers("You've Got Mail","Forrest Gump","American Psycho","American Assassin");
        addQuestion(new Question("\"Mama always said life was like a box of chocolates. You never know what you're gonna get.\"",
                answers,2,0,5,0));

        answers = setAnswers("Fast Five","The Fast and Furious","The Fate of The Furious","Fast and Furious 6");
        addQuestion(new Question("\"FAMILY\"",
                answers,9,0,5,0));

        answers = setAnswers("Shane","SHREK","Bonnie and Clyde","The Bank Job");
        addQuestion(new Question("\"We rob banks.\"",
                answers,3,0,5,0));

        answers = setAnswers("The Sixth Sense","Se7en","Donnie Brasco","Iron Man");
        addQuestion(new Question("\"I see dead people.\" ",
                answers,1,0,5,0));

        answers = setAnswers("The Avengers","Thor","Iron Man","SHREK");
        addQuestion(new Question("\"I am Iron Man\"",
                answers,3,0,5,0));

        answers = setAnswers("The Fifth Element","Frankenstein","SUPERBAD","American Pie 2");
        addQuestion(new Question("\"It's alive! It's alive!\"",
                answers,2,0,5,0));

        answers = setAnswers("Interstellar","Animal Crackers","Apollo 13","Bad Boys");
        addQuestion(new Question("\"Houston, we have a problem.\"",
                answers,3,0,5,0));

        answers = setAnswers("Dirty Harry","A league of Their Own","Bad Boys 2","V for Vendetta");
        addQuestion(new Question("\"You've got to ask yourself one question: 'Do I feel lucky?' Well, do ya, punk?\" ",
                answers,1,0,5,0));

        answers = setAnswers("American Pie ","The Age of 17","The Godfather Part II","Psycho");
        addQuestion(new Question("\"A boy's best friend is his mother.\" ",
                answers,4,0,5,0));

        answers = setAnswers("Long Shot","Warcraft","American Psycho","Animal Crackers");
        addQuestion(new Question("\"One morning I shot an elephant in my pajamas. How he got in my pajamas, I don't know.\" ",
                answers,4,0,5,0));

        answers = setAnswers(" Warcraft","Riddick","A League of Their Own","Gone With the Wind");
        addQuestion(new Question("\"There's no crying in baseball!\"",
                answers,3,0,5,0));

        answers = setAnswers("The Godfather Part II","Sons of the Desert","Good Will Hunting","Drive");
        addQuestion(new Question("\"Keep your friends close, but your enemies closer.\"",
                answers,1,0,5,0));

        answers = setAnswers("Casablanca","Scarface","The Adventures of Sherlock Holmes","The Lord of the Rings: The Return of the King");
        addQuestion(new Question("\"Say \"hello\" to my little friend!\"",
                answers,2,0,5,0));

        answers = setAnswers("American Pie 2","The Good, the Bad, the Ugly","The Graduate","The Shining");
        addQuestion(new Question("\"Mrs. Robinson, you're trying to seduce me. Aren't you?\"",
                answers,3,0,5,0));

        answers = setAnswers("Dawn of the Planet of the Apes","Avatar","King Kong","Kong: Skull Island");
        addQuestion(new Question("\"Apes together strong!... Caesar weak!\" \n" +
                "\"Koba weaker.\"",
                answers,1,0,5,0));

        answers = setAnswers("Lord of War","Warcraft","Poltergeist","Dr Strangelove");
        addQuestion(new Question("\"Gentlemen, you can't fight in here! This is the War Room!\"",
                answers,4,0,5,0));

        answers = setAnswers("King Kong","The Matrix","Wedding Crashers","John Wick");
        addQuestion(new Question("\"I know kung fu\"",
                answers,2,0,5,0));

        answers = setAnswers("Beyond The Forest","The Mechanic","Coming to America","Planet of the Apes");
        addQuestion(new Question("\"Get your stinking paws off me, you damned dirty ape.\"",
                answers,4,0,5,0));

        answers = setAnswers("The Shining","Ready Player One","Marathon Man","Sing");
        addQuestion(new Question("\"Here's Johnny!\"",
                answers,1,0,5,0));

        answers = setAnswers("The Avengers: Age of Ultron","Soylent Green","8 Mile","The Jazz Singer");
        addQuestion(new Question("\"Wait a minute, wait a minute. You ain't heard nothin' yet!\"",
                answers,4,0,5,0));

        answers = setAnswers("American Pie","The Avengers: Age of Ultron","A Streetcar Named Desire","Cars");
        addQuestion(new Question("\"There are no strings on me\"",
                answers,2,0,5,0));

        answers = setAnswers("Kung Fu Panda","Cars","Little Caesar","Terminator 2: Judgment Day");
        addQuestion(new Question("\"Ka-Chow\"",
                answers,2,0,5,0));

        answers = setAnswers("A Space Odyssey","Nightmare on elm street","Terminator 2 Judgment Day","Fast Five");
        addQuestion(new Question("\"Hasta la vista, baby.\"",
                answers,3,0,5,0));

        answers = setAnswers("Rocky II","King Kong","The Gentleman","Creed");
        addQuestion(new Question("\"Yo, Adrian!\"",
                answers,1,0,5,0));

        answers = setAnswers("The Lord Of The Rings","Inception","Dirty Harry","The Matrix");
        addQuestion(new Question("\"Mr. Anderson\"",
                answers,4,0,5,0));

        answers = setAnswers("The Matrix: Reloaded","The Hobbit: Desolation of Smaug","Men in Black","Dracula");
        addQuestion(new Question("\"Listen to them. Children of the night. What music they make.\"",
                answers,4,0,5,0));

        answers = setAnswers("The Lord of the Rings: Two Towers","Harry Potter and the sorcerer's stone","Passengers","42nd Street");
        addQuestion(new Question("\"My precious.\"",
                answers,1,0,5,0));

        answers = setAnswers("The Dark Knight","Ted 2","Spider-Man","Thor");
        addQuestion(new Question("\"You Know i'm something of a scientist myself \"",
                answers,3,0,5,0));

        answers = setAnswers("The Naughty Nineties","Goldfinger","Baywatch","Back to the Future");
        addQuestion(new Question("\"A martini. Shaken, not stirred.\"",
                answers,2,0,5,0));

        answers = setAnswers("On the Waterforont","Blade Runner","The Shawshank Redemption","Top Gun");
        addQuestion(new Question("\"I feel the need - the need for speed!\"",
                answers,4,0,5,0));

        answers = setAnswers("Dirty Dancing","The accountant","How to Train Your Dragon","Edge Of Tomorrow");
        addQuestion(new Question("\"Nobody puts Baby in a corner.\" ",
                answers,1,0,5,0));

        answers = setAnswers("Se7en","Requiem for a Dream","Titanic","Inception");
        addQuestion(new Question("\"I'm king of the world!\"",
                answers,3,0,5,0));

        answers = setAnswers("Gladiator","Gran Torino","Nobody","John Wick");
        addQuestion(new Question("\"Are you not entertained?\"",
                answers,1,0,5,0));

        answers = setAnswers("Finding Nemo","There Will Be Blood","Requiem for a Dream","TMNT");
        addQuestion(new Question("\"Just keep swimming\"",
                answers,1,0,5,0));

        answers = setAnswers("Joker","The Social Network","Dirty Harry","No Country for Old Men");
        addQuestion(new Question("\"What's the most you ever lost on a coin toss?\"",
                answers,4,0,5,0));

        answers = setAnswers("Inception","Good Will Hunting ","The Dark Knight","Green Mile");
        addQuestion(new Question("\"Why so serious?\"",
                answers,3,0,5,0));

        answers = setAnswers("Spider-Man","The Dark Knight","The Witch","Child Play");
        addQuestion(new Question("\"If your good at something never do it for free\"",
                answers,2,0,5,0));

        answers = setAnswers("The War With Grandpa","Bad Boys 2","The Social Network","Brokeback");
        addQuestion(new Question("\"A million dollars isn't cool. You know what's cool? \n" +
                "A billion dollars.\"",
                answers,3,0,5,0));

        answers = setAnswers("Blade Runner","The Butterfly Effect","Goldfinger","The Bicycle Thieves");
        addQuestion(new Question("\"I've seen things you people wouldn't believe. \n" +
                "Attack ships on fire off the shoulder of Orion. I \n" +
                "watched C-beams glitter in the dark near the \n" +
                "Tannhuser Gate. All those moments will be lost in \n" +
                "time, like tears in rain. Time to die.\"",
                answers,1,0,5,0));

        answers = setAnswers("The Wedding Ringer","Requiem for a Dream","47 Ronin","Aloha");
        addQuestion(new Question("\"Ah, it's not the same. They don't need me. I like the way I feel. I like \n" +
                "thinking about the red dress and the television and you and your father. Now when \n" +
                "I get the sun, I smile.\"",
                answers,2,0,5,0));

        answers = setAnswers("17 Again","The Tower","Requiem for a Dream","Norbit");
        addQuestion(new Question("\"Purple in the morning, blue in the afternoon, orange in the evening\"",
                answers,3,0,5,0));

        answers = setAnswers("Norbit","Rush Hour","Zodiac","The Usual Suspects");
        addQuestion(new Question("\"The greatest trick the devil ever pulled was to convince the world he didn't exist\"",
                answers,4,0,5,0));

        answers = setAnswers("Man of Steel","Project X","Back to the Future ","Die Hard");
        addQuestion(new Question("\"Roads...Where we are going we don't need roads\"",
                answers,3,0,5,0));

        answers = setAnswers("Blade Runner 2049","Who Framed Roger Rabbit","Project Almanac","You've Got Mail");
        addQuestion(new Question("\"I am not bad I am just drawn this way\"",
                answers,2,0,5,0));

        answers = setAnswers("Star Wars: Episode V","Back to the Future 3","Man of Steel","Men in Black");
        addQuestion(new Question("\"I am your father\"",
                answers,1,0,5,0));

        answers = setAnswers("Braveheart","Central Intelligence","Easy a","Skyfall");
        addQuestion(new Question("\"They may take our lives but they will never take our freedom\"",
                answers,1,0,5,0));

        answers = setAnswers("Snatch","Breaking bad","The Incredible Hulk","Fight Club ");
        addQuestion(new Question("\"The fist rule of.... is you never talk about ... The second rule of .....\"",
                answers,4,0,5,0));

        answers = setAnswers("The Proposal","Die Hard","Enemy at the Gates","Just Like Heaven");
        addQuestion(new Question("\"Yippee-Ki-Yay, Motherf*cker!\"",
                answers,2,0,5,0));

        answers = setAnswers("Aladdin","Good Will Hunting","Mulan","The Man From UNCLE");
        addQuestion(new Question("\"How You Like Them Apples?\"",
                answers,2,0,5,0));

        answers = setAnswers("Chucky","Quantum of Solace","Aladdin","The Hitman's Wife's Bodyguard");
        addQuestion(new Question("\"You have never had a friend like me!!\"",
                answers,3,0,5,0));

        answers = setAnswers("Ghost of Girlfriends Past","The Gentleman","Dazed and Confused","The Break Up");
        addQuestion(new Question("\"Alright, Alright, Alright\"",
                answers,3,0,5,0));

        answers = setAnswers("300","Troy","In Time","Gladiator");
        addQuestion(new Question("\"This is Sparta!!!\"",
                answers,1,0,5,0));

        answers = setAnswers("Lord of the Rings","Taken","The Hobbit: The Battle of The Five Armies","Plan B ");
        addQuestion(new Question("\"You shall not pass!!\"",
                answers,1,0,5,0));

        answers = setAnswers("Planet of the Apes","Never Back Down","Predator","Terminator");
        addQuestion(new Question("\"Get to the choppa!!! \"",
                answers,3,0,5,0));

        answers = setAnswers("Kung fu Panda 3","Despicable Me","Desperado","Toy Story ");
        addQuestion(new Question("\"To infinity and beyond\"",
                answers,4,0,5,0));

        answers = setAnswers("Se7en","Police Academy","Bruce Almighty","Zodiac");
        addQuestion(new Question("\"Aaaa Whats in the box... whats in the f**king box\"",
                answers,1,0,5,0));

        answers = setAnswers("Troy","Gladiator","Spartacus","Bem Hur");
        addQuestion(new Question("\"My name is Maximus Decimus Meridius, Commander of the Armies of the North, General of the \n" +
                "Felix Legions, loyal servant to the true emperor, Marcus Aurelius. Father to a murdered son, \n" +
                "husband to a murdered wife. And I will have my vengeance, in this life or the next.\"",
                answers,2,0,5,0));

        answers = setAnswers("Mad Max: Fury Road","The Hateful Eight","Just Go With It","GOLD");
        addQuestion(new Question("\"Oh, what a day... what a lovely day!\"",
                answers,1,0,5,0));

        answers = setAnswers("Frankenstein","Zombieland","Mad Max: Fury Road","In Time");
        addQuestion(new Question("\"I live, I die. I LIVE AGAIN!\"",
                answers,3,0,5,0));

        answers = setAnswers("Harry Potter","Fantastic Beasts","Free Guy","Assassin's Creed");
        addQuestion(new Question("\"Its leviOsa not levioSA\"",
                answers,1,0,5,0));

        answers = setAnswers("Die Hard","Gladiator","Troy","300");
        addQuestion(new Question("\"Death smiles at us all. All a man can do is smile back \"",
                answers,2,0,5,0));

        answers = setAnswers("Snakes on a plane","The Hitman's Bodyguard","Pulp Fiction","Star Wars ");
        addQuestion(new Question("\"English motherf**ker, do you speak it?\"",
                answers,3,0,5,0));

        answers = setAnswers("Whiplash","Good Will Hunting","Inception","Enemy Of The State");
        addQuestion(new Question("\"There are no two words in the English language more harmful than \"good job\".\"",
                answers,1,0,5,0));

        answers = setAnswers("Wolf of Wall Street","The Avengers: Endgame","Love","Harry Potter");
        addQuestion(new Question("\"Always\"",
                answers,4,0,5,0));
    }
}
