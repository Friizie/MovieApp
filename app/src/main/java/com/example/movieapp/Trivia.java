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
        switch (dif){
            case 0:
                for (Question q : questions) {
                    if (q.getDifficulty() == dif) {
                        list.add(q);
                    }
                }
                break;
            case 1:
                for (Question q : questions) {
                if(q.getDifficulty() != 2)
                    list.add(q);
            }
                break;
            case 2:
                for (Question q : questions) {
                    if(q.getDifficulty() == 2)
                        list.add(q);
                }
                break;
            default: selectedquestions = questions;
        }

        selectedquestions = list;
    }

    // helper function for easier setup
    private ArrayList<String> setAnswers(String one, String two, String three, String four){
        return new ArrayList<>(Arrays.asList(one.toLowerCase(),two.toLowerCase(),three.toLowerCase(),four.toLowerCase()));
    }

    private ArrayList<String> setAnswers(String[] answers) {
        for (int i=0;i<answers.length;i++){
            answers[i] = answers[i].toLowerCase().replaceAll("  +"," ")
                    .replaceAll("^ +","").replaceAll(" +$","");
        }
        return new ArrayList<>(Arrays.asList(answers));
    }


    void initQuestions() {
        ArrayList<String> answers;

//        answers = setAnswers("Answer 1","Answer 2","Answer 3","Answer 4");
//        addQuestion(new Question("Question?", answers,1,2,5,R.drawable.qmark));

//        answers = setAnswers(new String[]{"Answer 1", "Answer 2","Answer","Answer 3","Answer 4"});
//        addQuestion(new Question("Question?", answers,1,2,5,R.drawable.qmark));

                              // question // list // correct // 0,1,2 poeni // slika

//         Hard
        answers = setAnswers("The Wolf Of Wall Street","Ride along","Sudden impact","The day the earth stood still");
        addQuestion(new Question("\"Go ahead, make my day.\"",
                answers,3,1,5,0));


        answers = setAnswers("The good, the bad, the ugly","Little women","12 Angry men","Gone with the wind");
        addQuestion(new Question("\"Frankly, my dear, I don't give a damn.\"",
                answers,4,1,5,0));


        answers = setAnswers("On the waterfront","Gran torino","Rocky","Spider-Man");
        addQuestion(new Question("\"You don't understand! I coulda had class. I coulda been a contender. I could've been somebody, instead of a bum, which is what I am.\"",
                answers,1,1,7,0));

        answers = setAnswers("The Wizard of Oz","Gone with the wind","The Maze Runner","King Kong");
        addQuestion(new Question("\"Toto, I've got a feeling we're not in Kansas anymore.\"",
                answers,1,1,9,0));

        answers = setAnswers("Star Wars","Loser","Casablanca","Peaky blinders");
        addQuestion(new Question("\"Here's looking at you, kid.\"",
                answers,3,1,5,0));

        answers = setAnswers("The girl next door","Sunset Boulevard","Aloha","Gangster Squad");
        addQuestion(new Question("\"All right, Mr. DeMille, I'm ready for my close-up.\"",
                answers,2,1,5,0));

        answers = setAnswers("Gangster Squad","All About Eve","Ocean's thirteen","Drive");
        addQuestion(new Question("\"You talking to God Mitch, so you might as well swear to me\"",
                answers,1,1,5,0));

        answers = setAnswers("Spider-Man","All About Eve","Mission: Impossible","The old guard");
        addQuestion(new Question("\"Fasten your seatbelts. It's going to be a bumpy night.\"",
                answers,2,1,5,0));

        answers = setAnswers("Taxi 3","Star Wars","Madagascar","Hand Luke");
        addQuestion(new Question("\"What we've got here is failure to communicate.\"",
                answers,4,1,5,0));

        answers = setAnswers("E.T The Extra-Terrestrial","The Maltese Falcon","Home Alone","The Shining");
        addQuestion(new Question("\"The stuff that dreams are made of.\"",
                answers,2,1,7,0));

        answers = setAnswers("E.T The Extra-Terrestrial","Citizen Kane","White Heat","White House Down");
        addQuestion(new Question("\"E.T. phone home.\"",
                answers,1,1,5,0));

        answers = setAnswers("Aloha","American Sniper","In the Heat of The Night","IT");
        addQuestion(new Question("\"They call me Mister Tibbs!\"",
                answers,3,1,10,0));

        answers = setAnswers("Titanic","Joker","White Heat","Die Hard");
        addQuestion(new Question("\"Made it, Ma! Top of the world!\"",
                answers,3,1,5,0));

        answers = setAnswers("Network","Dirty Harry","Breaking bad","Casablanca");
        addQuestion(new Question("\"I'm as mad as hell, and I'm not going to take this anymore!\"",
                answers,1,1,5,0));

        answers = setAnswers("Sunset Boulevard","Titanic","The Prestige","The Lord of the Rings");
        addQuestion(new Question("\"I am big! It's the pictures that got small.\"",
                answers,1,1,5,0));

        answers = setAnswers("The Amazing Spider-Man","She Done Him Wrong","Batman Begins","Batman Returns");
        addQuestion(new Question("\"Why don't you come up sometime and see me?\"",
                answers,2,1,5,0));

        answers = setAnswers("Battleship","Casablanca","Mr. and Mrs Smith","The Hobbit");
        addQuestion(new Question("\"Play it, Sam. Play 'As Time Goes By.'\"",
                answers,2,1,5,0));

        answers = setAnswers("Ride Along","The Nice Guys","Dark Shadows","The Pride of the Yankees");
        addQuestion(new Question("\"Today, I consider myself the luckiest man on the face of the earth.\"",
                answers,4,1,6,0));

        answers = setAnswers("Field of Dreams","The Graduate","Home Alone 3","Mama");
        addQuestion(new Question("\"If you build it, he will come.\"",
                answers,1,1,5,0));

        answers = setAnswers("Some Like it Hot","Now, Voyager","Superman Returns","Shane");
        addQuestion(new Question("\"Oh, Jerry, don't let's ask for the moon. We have the stars.\"",
                answers,2,1,10,0));

        answers = setAnswers("Aloha","1917","Jerry Maguire","Annie Hall");
        addQuestion(new Question("\"You had me at? hello.?\"",
                answers,3,1,5,0));

        answers = setAnswers("2012","The Killing Joke","Inception","Annie Hall");
        addQuestion(new Question("\"La-dee-da, la-dee-da.\"",
                answers,4,1,8,0));

        answers = setAnswers("Lord Of War","Bruno","Wall Street","The Great Gatsby");
        addQuestion(new Question("\"Greed, for lack of a better word, is good.\"",
                answers,1,1,5,0));

        answers = setAnswers("Scarface","Beyond the Forest","Gone With the Wind","The Do Over");
        addQuestion(new Question("\"As God is my witness, I'll never be hungry again.\" ",
                answers,3,1,9,0));

        answers = setAnswers("Loser","Sons of The Desert","Ted","Naked Gun");
        addQuestion(new Question("\"Well, here's another nice mess you've gotten me into!\"",
                answers,2,1,5,0));

        answers = setAnswers("Kung Fu Panda","Straight Outta Compton","Destination Wedding","The Adventures of Sherlock Holmes");
        addQuestion(new Question("\"Elementary, my dear Watson.\"",
                answers,4,1,9,0));

        answers = setAnswers("Little Caesar","Inception","Mr. No","Doctor Sleep");
        addQuestion(new Question("\"Mother of mercy, is this the end of Rico?\"",
                answers,1,1,9,0));

        answers = setAnswers("Chinatown","Sing 2","No time to Die","Rain Man");
        addQuestion(new Question("\"Forget it, Jake, it's Chinatown.\"",
                answers,1,1,9,0));

        answers = setAnswers("Rain Man","Hangover","A Streetcar Named Desire","Thor: The Dark World");
        addQuestion(new Question("\"I have always depended on the kindness of strangers.\"",
                answers,3,1,5,0));

        answers = setAnswers("Rocky II","Airplane","Shrek 2","Funny Girl");
        addQuestion(new Question("Striker: \"Surely you can't be serious.\"\nRumack: \"I am serious?and don't call me Shirley.\"",
                answers,2,1,10,0));

        answers = setAnswers("Spectre","Dog Day Afternoon","King Kong","Godzilla");
        addQuestion(new Question("\"Oh, no, it wasn't the airplanes. It was Beauty killed the Beast.\"",
                answers,3,1,8,0));

        answers = setAnswers("Goldfinger","On Golden Pond","Harry Potter and the Prisoner of Azkaban","No Time to Die");
        addQuestion(new Question("\"Listen to me, mister. You're my knight in shining armor. Don't you forget it. \n" +
                "You're going to get back on that horse, and \n" +
                "I'm going to be right behind you, holding on tight, \n" +
                "and away we're gonna go, go, go!\"",
                answers,2,1,8,0));

        answers = setAnswers("Knut Rockne All American","The Matrix","Kung Fu Fury","The Naught Nineties");
        addQuestion(new Question("\"Tell 'em to go out there with all they got and win just one for the Gipper.\"",
                answers,1,1,5,0));

        answers = setAnswers("Auntie Meme","Spider-Man","Gladiator","Caddyshack");
        addQuestion(new Question("\"Cinderella story. Outta nowhere. A former\n" +
                "greenskeeper, now, about to become the Masters champion.\n" +
                "It looks like a mirac...It's in\n" +
                "the hole! It's in the hole! It's in the hole!\"",
                answers,4,1,8,0));

        answers = setAnswers("Titanic","Top Gun","Dead Poets Society","Caddyshack");
        addQuestion(new Question("\"Carpe diem. Seize the day, boys. Make your lives extraordinary.\"",
                answers,3,1,5,0));

        answers = setAnswers("Yankee Doodle Dandy","47 Ronin","TENET","TORQUE");
        addQuestion(new Question("\"My mother thanks you. My father thanks you. My sister thanks you. And I thank you.\"",
                answers,1,1,7,0));

        answers = setAnswers("Se7en","Requiem for a dream","The Wizard of Oz","Finding Nemo");
        addQuestion(new Question("\"I'll get you, my pretty, and your little dog, too!\"",
                answers,3,1,6,0));

        answers = setAnswers("Finding Dory","Broke Back","Spider-Man: Homecoming","The Dark Knight");
        addQuestion(new Question("\"I wish I knew how to quit you\"",
                answers,2,1,8,0));

        answers = setAnswers("There Will be Blood","The Good, the bad, the Ugly","Mission: Impossible","Casino Royal");
        addQuestion(new Question("\"I drink your milkshake\"",
                answers,1,1,9,0));

        answers = setAnswers("Child's Play","The Social Network","Die Another Day","The Witch");
        addQuestion(new Question("\"Wouldst thou like to live deliciously?\" ",
                answers,4,1,10,0));

        answers = setAnswers("Parasite","The Bicycle Thieves","Shutter Island","Thor Ragnarok");
        addQuestion(new Question("\"Why should I kill myself worrying when I'll end up \n" +
                "just as dead?\"",
                answers,2,1,5,0));

        answers = setAnswers("The Silence of the Lambs","Parasite","Robin Hood: Prince of Thieves","Back to the future");
        addQuestion(new Question("\"You know what kind of plan never fails? No plan. \n" +
                "No plan at all. You know why? Because life cannot \n" +
                "be planned.\"",
                answers,2,1,5,0));

        answers = setAnswers("The Wedding Ringer","Requiem for a Dream","47 Ronin","Aloha");
        addQuestion(new Question("\"Ah, it's not the same. They don't need me. I like the way I feel. I like \n" +
                "thinking about the red dress and the television and you and your father. Now when \n" +
                "I get the sun, I smile.\"",
                answers,2,1,5,0));

        answers = setAnswers("Norbit","Rush Hour","Zodiac","The Usual Suspects");
        addQuestion(new Question("\"The greatest trick the devil ever pulled was to convince the world he didn't exist\"",
                answers,4,1,8,0));

        answers = setAnswers("Good Morning Vietnam","Blade Runner","Tootsie","When Harry Met Sally");
        addQuestion(new Question("\"Gooooooooooooooooooooood moring Vietnaaaam!\"",
                answers,1,1,8,0));

        answers = setAnswers("Blade Runner 2049","Who Framed Roger Rabbit","Project Almanac","You've Got Mail");
        addQuestion(new Question("\"Iam not bad iam just drawn this way\"",
                answers,2,1,10,0));

        answers = setAnswers("Blended","Murder Mystery","The Karate Kid","Body of Lies");
        addQuestion(new Question("\" Wax on right hand, Wax off left hand, Wax on, Wax off\"",
                answers,3,1,9,0));

        answers = setAnswers("Troy","Gladiator","Spartacus","Bem Hur");
        addQuestion(new Question("\"My name is Maximus Decimus Meridius, Commander of the Armies of the North, General of the \n" +
                "Felix Legions, loyal servant to the true emperor, Marcus Aurelius. Father to a murdered son, \n" +
                "husband to a murdered wife. And I will have my vengeance, in this life or the next.\"",
                answers,2,1,5,0));

        answers = setAnswers("Frankenstein","Zombieland","Mad Max: Fury Road","In Time");
        addQuestion(new Question("\"I live, I die. I LIVE AGAIN!\"",
                answers,3,1,9,0));

        answers = setAnswers("The Jazz Singer","Finding Nemo","Pulp Fiction","Whiplash");
        addQuestion(new Question("\"I was there to push people beyond what's expected of them\"",
                answers,4,1,8,0));

        answers = setAnswers("Whiplash","Good Will Hunting","Inception","Enemy Of The State");
        addQuestion(new Question("\"There are no two words in the English language more harmful than \"good job\".\"",
                answers,1,1,5,0));

        answers = setAnswers("Dog Day Afternoon","Ben-Hur","Leon: The Professional","Saving Private Ryan");
        addQuestion(new Question("\"Its when you really start to fear death that you learn to appreciate life.\"",
                answers,3,1,5,0));

        answers = setAnswers("Home Alone","Leon: The Professional","Project Power","Dirty Dancing");
        addQuestion(new Question("\"Is life always this hard, or is it just when you're a kid\"\n" +
                "\"Always\"",
                answers,2,1,7,0));

        answers = setAnswers("The Lion King","Cars","Sing 2","Spy");
        addQuestion(new Question("\"I'am surrounded by idiots\"",
                answers,1,1,7,0));

        answers = setAnswers("Mad Max","Joker","Blow","American Psycho");
        addQuestion(new Question("\"I believe in taking care of myself, in \n" +
                "a balanced diet, in a rigorous exercise routine.\n" +
                "In the morning, if my face is a little puffy, I'll \n" +
                "put on an  icepack while doing my stomach crunches.\n" +
                "I can do a thousand now. After I remove the icepack, \n" +
                "I use a deep-pore cleanser lotion. In The shower...\"",
                answers,4,1,5,0));

        answers = setAnswers("The Founder","The Pink Panther","Chef","Big Night");
        addQuestion(new Question("\"I would like to buy a hamburger\"",
                answers,2,1,7,0));

        answers = setAnswers("Meet Joe Black","Hitchcock","How the Grinch Stole Christmas","Hancock");
        addQuestion(new Question("\"There's no sense living your life without this.\n" +
                "To make the journey and not fall deeply in love, \n" +
                "well, you haven't lived a life at all. But you have\n" +
                "to try, cause if you haven't tried, you haven't lived.\"",
                answers,1,1,10,0));

        answers = setAnswers("New Year's Eve","A Lot Like Love","How the Grinch Stole Christmas","Snowpiercer");
        addQuestion(new Question("\"It came without ribbons, it came without tags.\n" +
                "It came without packages, boxes, or bags.\"",
                answers,3,1,8,0));

        answers = setAnswers("Fear and Loathing in Las Vegas","Ocean's Eleven","The Grand Budapest Hotel","Hotel Transylvania");
        addQuestion(new Question("\"Terry, you of all people should know, in your hotel,\n" +
                "there's always someone watching.\"",
                answers,2,1,6,0));

        answers = setAnswers("Blow","GoodFellas","Fear and Loathing in Las Vegas","Love and Other Drugs");
        addQuestion(new Question("\"I'm a relatively respectable citizen. Multiple felon \n" +
                "perhaps, but certainly not dangerous\"",
                answers,3,1,9,0));

        answers = setAnswers("Ted","Home Alone","Daddy's Home","The Da Vinci Code");
        addQuestion(new Question("\"Why are you crying?\"\n" +
                "\"My d**k is squished by the TV.\"",
                answers,1,1,5,0));

        answers = setAnswers("Inferno","You've Got Mail","Batman","The Da Vinci Code");
        addQuestion(new Question("\"Men go to far greater lengths to avoid what they\n" +
                "fear than to obtain what they desire.\"",
                answers,4,1,8,0));

        answers = setAnswers("Casino","Casino Royale","Molly's Game","The Grand");
        addQuestion(new Question("\"I'm sorry. That last hand... nearly killed me.\"",
                answers,2,1,7,0));

        answers = setAnswers("Gangster Squad","Blow","Casino","Molly's Game");
        addQuestion(new Question("\"You put my f***in' money to sleep. You go get my\n" +
                "money or I'll put your f***in' brain to sleep!\"",
                answers,3,1,5,0));


        answers = setAnswers("Casino","Suicide Squad","The good, the bad, the ugly","Bruno");
        addQuestion(new Question("\"There's three ways to do things, the right way,\n" +
                "the wrong way and the way that i do it\"",
                answers,1,1,9,0));

        answers = setAnswers("Joker","Suicide Squad","The Dark Knight","Once Upon a Time in America");
        addQuestion(new Question("\"Huh? What was that? I should kill everyone and escape?\n" +
                "Sorry. The voices.\n" +
                "I'm kidding! Jeez! That's not what they really said.\"",
                answers,2,1,5,0));

        answers = setAnswers("Now You See Me","Cats","The Prestige","Harry Potter");
        addQuestion(new Question("\"Man's reach exceeds his imagination!\"",
                answers,3,1,10,0));

        answers = setAnswers("Midnight Sun","Midnight in Paris","The Vampire Diaries","The Notebook");
        addQuestion(new Question("\"I am nothing special, of this I am sure. I am a common\n" +
                "man with common thoughts and I've led a common life. There are\n" +
                "no monuments dedicated to me and my name will soon be forgotten,\n" +
                "but I've loved another with all my heart and soul,\n" +
                "and to me, this has always been enough..\"",
                answers,4,1,5,0));

        answers = setAnswers("Hugo","Up","Kung Fu Panda","Harry Potter");
        addQuestion(new Question("\"This might be an adventure, and I've never had one before - outside of books, at least.\"",
                answers,1,1,8,0));

        answers = setAnswers("Fury","The Green Mile","Nobody","Inferno");
        addQuestion(new Question("\"Please boss, don't put that thing over my face, don't put me in the dark. I's afraid of the dark.\"",
                answers,2,1,9,0));

        answers = setAnswers("The Green Mile","E.T the Extra-Terrestrial","Ma","Jennifer's Body");
        addQuestion(new Question("\"He kill them wi' their love. Wi' their love fo' each other.\n" +
                "That's how it is, every day, all over the world.\"",
                answers,1,1,6,0));

        answers = setAnswers("Enemy of the State","White House Down","Independence Day","Nixon");
        addQuestion(new Question("\"Look at us. Everybody's trying to get out of Washington, and we're the only schmucks trying to get in.\"",
                answers,3,1,9,0));

        answers = setAnswers("Thor","Batman v Superman","The Dark Knight","The Huntsman");
        addQuestion(new Question("\"Where is she!?\"",
                answers,3,1,6,0));

        answers = setAnswers("La La Land","Happy End","Vanila Sky","Inception");
        addQuestion(new Question("\"You musn't be afraid to dream a little bigger darling.\"",
                answers,4,1,7,0));

        answers = setAnswers("Steve Jobs","The Man Who Knew Infinity","The Theory of Everything","Inception");
        addQuestion(new Question("\"An idea is like a virus. Resilient. Highly contagious. And even the smallest\n" +
                "seed of an idea can grow. It can grow to define or destroy you.\"",
                answers,4,1,10,0));

        answers = setAnswers("The Fifth Element","12 Monkeys","Die Hard","Armageddon");
        addQuestion(new Question("\"You wanna play it soft. We'll play it soft. You wanna play it hard. Let's play it hard.\"",
                answers,1,1,8,0));

        answers = setAnswers("Toy Story","The Fifth Element","Bee Movie","Home Alone");
        addQuestion(new Question("\"Bzzzzzzzzzzzzzzzzzt!\"",
                answers,2,1,10,0));

        answers = setAnswers("Don't Look Up","Independence Day","Armageddon","Apollo 13");
        addQuestion(new Question("\"Hey, guys, remember: we're, we're heroes now. So that incident with me and the gun on the asteroid. Let`s keep that under wraps, all right!\"",
                answers,3,1,10,0));

        answers = setAnswers("The Martian","Armageddon","Gravity","First Man");
        addQuestion(new Question("\"What's up Harry? Did N.A.S.A. find oil on Uranus? Man.\"",
                answers,2,1,10,0));

        answers = setAnswers("The Martian","A Star Is Born","Baby Driver","Get Him to The Greek");
        addQuestion(new Question("\"I am definitely going to die up here ... if I have to listen to any more god-awful disco music.\"",
                answers,1,1,8,0));

        answers = setAnswers("Captain America","The Martian","The Avengers","Scary Movie");
        addQuestion(new Question("\"I admit it's fatally dangerous, but I'd get to fly around like Iron Man.\"",
                answers,2,1,6,0));

        answers = setAnswers("The Night Before","Mike and Dave Need Wedding Dates","A Star Is Born","ZooLander");
        addQuestion(new Question("\"How you doin', papo?\n" +
                "How am I doing? I'm doing all right if I can get a f***ing drink.\"",
                answers,3,1,9,0));

        answers = setAnswers("Project X","American Pie","High School Musical","Superbad");
        addQuestion(new Question("\"I have to admit, you know, I did the fair bit of masturbating when I was\n" +
                "a little younger. I used to call it stroking the salami, yeah, you\n" +
                "know, pounding the old pud. I never did it with baked goods, but you \n" +
                "know your uncle Mort, he pets the one-eyed snake 5-6 times a day.\"",
                answers,2,1,7,0));

        answers = setAnswers("Project X","The Neighbors","Office Christmas Party","American Pie");
        addQuestion(new Question("\"Costaaaaaaaaaa! Give me back my fucking gnome!\"",
                answers,1,1,9,0));

        answers = setAnswers("Superbad","Easy A","22 Jump Street","American Pie");
        addQuestion(new Question("\"Dude, I'm so sorry for being a homophone\"",
                answers,3,1,8,0));

        answers = setAnswers("Ted","22 Jump Street","The Other Guys","Project X");
        addQuestion(new Question("\"The only thing your working on is diabetes you fat f**k.\"",
                answers,4,1,10,0));

        answers = setAnswers("Bad Boys","22 Jump Street","The Naked Gun","The Nice Guys");
        addQuestion(new Question("\"My name's Jeff...\"",
                answers,2,1,5,0));

        answers = setAnswers("8 Mile","About Last Night","Passing","Straight Outta Compton\n");
        addQuestion(new Question("\"She kinda... preoccupied wit some real ni**a d**k\"",
                answers,4,1,9,0));

        answers = setAnswers("Tropic Thunder","Ted 2","Spy","Why Him?");
        addQuestion(new Question("\"You went full retard man, never go full retard.\"",
                answers,1,1,8,0));

        answers = setAnswers("This is the End","Tropic Thunder","Jumper","Jumanji");
        addQuestion(new Question("\"Man were lost, were super lost!\"",
                answers,2,1,10,0));

        answers = setAnswers("Coach Carter","Mama","Vacation","Space Jam");
        addQuestion(new Question("\"C'mon Michael it's Game Time. Get your Hanes on, lace up your Nike's, grab your\n" +
                "Weaties and your Gatorade, and we'll pick up a Big Mac on the way to the ballpark.\"",
                answers,4,1,7,0));

        answers = setAnswers("Coach Carter","17 Again","Space Jam","The Avengers");
        addQuestion(new Question("\"You said we're a team. One person struggles, we all struggle. One person triumphs, we all triumph.\"",
                answers,1,1,9,0));

        answers = setAnswers("Tenet","Deep Impact","I am Legend","Watchmen");
        addQuestion(new Question("\"The people who are trying to make the world worse are not taking a day off. How can I? Light up the darkness.\"",
                answers,3,1,8,0));

        answers = setAnswers("Peter Pan","Captain Philips","The Pirates","Pirate's of the Caribbean");
        addQuestion(new Question("\"That's Gotta be the Best Pirate I've Ever Seen\"",
                answers,4,1,7,0));

        answers = setAnswers("The Transporter","Enemy of the State","Casino","Taxi");
        addQuestion(new Question("\"Rule 1: Never change the deal.\n" +
                "Rule 2: No names.\n" +
                "Rule 3: Never open the package.\"",
                answers,1,1,7,0));

        answers = setAnswers("Baby Driver","IT","John Wick","The Equalizer");
        addQuestion(new Question("\"You punched me, made me walk through shitty water, dragged me through\n" +
                "a crackhouse... and now I'm gonna have to kill this f***ing clown.\"",
                answers,2,1,8,0));

        // total Hard questions : 100



        // Easy

        answers = setAnswers("Penguins of Madagascar","Just go with it","SHREK","The Boys");
        addQuestion(new Question("\"Just smile and wave boys...smile and wave...\"",
                answers,1,0,6,0));

        answers = setAnswers("Ocean's Eleven","The Godfather","Scary Movie 1","The Dictator");
        addQuestion(new Question("\"I'm going to make him an offer he can't refuse.\"",
                answers,2,0,7,0));

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
                answers,1,0,9,0));

        answers = setAnswers("Casablanca","Love Story","The Dark Knight Rises","Taxi 1");
        addQuestion(new Question("\"Louis, I think this is the beginning of a beautiful friendship.\"",
                answers,1,0,6,0));

        answers = setAnswers("Hannibal","The Silence Of the Lambs","The Dark Knight","Joker");
        addQuestion(new Question("\"A census taker once tried to test me. I ate his liver with some fava beans and a nice Chianti.\"",
                answers,2,0,7,0));

        answers = setAnswers("Dr.No","Star Wars: Empire Strikes Back","The Story of Us","Casino");
        addQuestion(new Question("\"Bond. James Bond.\"",
                answers,1,0,10,0));

        answers = setAnswers("Tarzan","Home Alone","Casino Royal","The Wizard of Oz");
        addQuestion(new Question("\"There's no place like home.\" ",
                answers,4,0,6,0));

        answers = setAnswers("The Mummy","She Done Him Wrong","Jerry Maguire","The Bourne Supremacy");
        addQuestion(new Question("\"Show me the money!\"",
                answers,3,0,8,0));

        answers = setAnswers("Dirty Harry","Grand Hotel","Midnight Cowboy","Scarface");
        addQuestion(new Question("\"I'm walking here! I'm walking here!\"",
                answers,3,0,8,0));

        answers = setAnswers("Liar Liar","A Few Good Men","Fury","Die Another Day");
        addQuestion(new Question("\"You can't handle the truth!\"",
                answers,2,0,6,0));

        answers = setAnswers("Gone With the wind","The Shawshank Redemption","Leon the Professional","Rain Man");
        addQuestion(new Question("\"After all, tomorrow is another day!\"",
                answers,1,0,7,0));

        answers = setAnswers("Jaws","To Have and Have Not","To All the Boys I Loved","When Harry Met Sally");
        addQuestion(new Question("\"I'll have what she's having.\"",
                answers,4,0,10,0));

        answers = setAnswers("Jaws","Saw","The Notebook","How to Lose a Guy In 10 Days");
        addQuestion(new Question("\"You're gonna need a bigger boat.\"",
                answers,1,0,7,0));

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
                answers,3,0,8,0));

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
                answers,4,0,9,0));

        answers = setAnswers("American Pie","The Avengers: Age of Ultron","A Streetcar Named Desire","Cars");
        addQuestion(new Question("\"There are no strings on me\"",
                answers,2,0,9,0));

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
                answers,4,0,7,0));

        answers = setAnswers("Dirty Dancing","The accountant","How to Train Your Dragon","Edge Of Tomorrow");
        addQuestion(new Question("\"Nobody puts Baby in a corner.\" ",
                answers,1,0,10,0));

        answers = setAnswers("Se7en","Requiem for a Dream","Titanic","Inception");
        addQuestion(new Question("\"I'm king of the world!\"",
                answers,3,0,6,0));

        answers = setAnswers("Gladiator","Gran Torino","Nobody","John Wick");
        addQuestion(new Question("\"Are you not entertained?\"",
                answers,1,0,7,0));

        answers = setAnswers("Finding Nemo","There Will Be Blood","Requiem for a Dream","TMNT");
        addQuestion(new Question("\"Just keep swimming\"",
                answers,1,0,9,0));

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
                answers,3,0,10,0));

        answers = setAnswers("Ghost of Girlfriends Past","The Gentleman","Dazed and Confused","The Break Up");
        addQuestion(new Question("\"Alright, Alright, Alright\"",
                answers,3,0,9,0));

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
        addQuestion(new Question("\"Aaaa Whats in the box... whats in the f**king box!?\"",
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
                answers,3,0,9,0));

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
                answers,1,0,10,0));

        answers = setAnswers("Wolf of Wall Street","The Avengers: Endgame","Love","Harry Potter");
        addQuestion(new Question("\"Always\"",
                answers,4,0,7,0));

        answers = setAnswers("Leon the Professional","Playtime","V for Vendetta","The Big Blue");
        addQuestion(new Question("\"Voila! In view humble vaudevillian veteran, cast vicariously as both victim and villain\n" +
                "by the vicissitudes of fate. This visage, no mere veneer of vanity, is a vestige\n" +
                "of the “vox populi” now vacant, vanished. However, this valorous visitation of a bygone vexation\n" +
                "stands vivified, and has vowed to vanquish...\"",
                answers,3,0,5,0));

        answers = setAnswers("Notorious","8 Mile","All Eyez on Me","Straight Outta Compton");
        addQuestion(new Question("\"F**k the beat, I'll go a capella! F**k a Papa Doc, \n" +
                "f**k a clock, f**k a trailer, f**k everybody! F**k y'all if\n" +
                "you doubt me! I'm a piece of f**king white trash, I say it proudly! And \n" +
                "f**k this battle, I don't wanna win, i'm outtie. \n" +
                "Here, tell these people something they don't know about me.\"",
                answers,4,0,8,0));

        answers = setAnswers("Superbad","American Pie","Hot Pursuit","8 mile");
        addQuestion(new Question("\"I am McLovin!\"",
                answers,1,0,7,0));


        answers = setAnswers("The Disaster Artist","Once Upon a Time in Hollywood","Tropic Thunder","Holidate");
        addQuestion(new Question("\"I'm the Dude, playing a dude, disguised as another dude!\"",
                answers,3,0,5,0));


        answers = setAnswers("Superman","Mama","Vacation","Space Jam");
        addQuestion(new Question("\"But mommy, I don't want to go to school today. I want to stay home and bake cookies with you!\"",
                answers,4,0,9,0));

        answers = setAnswers("Ouija","Scary Movie","Scream","Saw");
        addQuestion(new Question("\"Do you want to play a game?\"",
                answers,4,0,10,0));

        answers = setAnswers("Scary Movie","Scream","Insidious","Hitch");
        addQuestion(new Question("\"Do you like scary movies?\"",
                answers,2,0,6,0));

        answers = setAnswers("Dracula","James Bond","Focus","The Great Gatsby");
        addQuestion(new Question("\"I never drink...wine.\"",
                answers,1,0,10,0));

        answers = setAnswers("Vice","The Hitman's Bodyguard","Get Out","Rampage");
        addQuestion(new Question("\"By The Way, I Would Have Voted For Obama For A Third Term, If I Could.\"",
                answers,3,0,8,0));

        answers = setAnswers("The Departed","Memento","Alien","The Great Dictator");
        addQuestion(new Question("\"I'm gonna go have a smoke right now. You want a smoke? You don't smoke, do ya, right? \n" +
                "What are ya, one of those fitness freaks, huh? Go f**k yourself.\"",
                answers,1,0,6,0));

        answers = setAnswers("Tropic Thunder","Memento","Amadeus","Hamilton");
        addQuestion(new Question("\"Enter OK, so what am I doing?\n" +
                "Oh, I'm chasing this guy.\n" +
                "No, he's chasing me.\"",
                answers,2,0,9,0));

        answers = setAnswers("Apollo 13","Armageddon","Alien","Deep Impact");
        addQuestion(new Question("\"If we ain't out of here in ten minutes, we won't need no rocket to fly through space!\"",
                answers,3,0,10,0));

        answers = setAnswers("Full Metal Jacket","War","Saving Private Ryan","Hacksaw Ridge");
        addQuestion(new Question("\"Well here`s something you won`t like, Private Snowball! They don`t serve \n" +
                "fried chicken and watermelon down in the mess hall every day!\"",
                answers,1,0,5,0));


        answers = setAnswers("The 5th Wave","Hacksaw Ridge","American pie","Game of Thrones");
        addQuestion(new Question("\"That's what i do drink and know things\"",
                answers,4,0,5,0));

        answers = setAnswers("The Boys","Red 2","Bad Boys","Spenser Confidential");
        addQuestion(new Question("\"F**king Diabolical\"",
                answers,1,0,5,0));

        answers = setAnswers("Wolf of Wall Street","The Avengers: Endgame","Love","Harry Potter");
        addQuestion(new Question("\"Always\"",
                answers,4,0,7,0));

        answers = setAnswers("The Accountant","Breaking Bad","Tomb Raider","Hitman: Agent 47");
        addQuestion(new Question("\"I am the danger. A guy opens his door and gets shot, and you think that of me? \n" +
                "No! I am the one who knocks!\"",
                answers,2,0,5,0));

        // Hard

        answers = setAnswers(new String[]{"sudden impact"});
        addQuestion(new Question("\"Go ahead, make my day.\"",
                answers,3,2,5,0));


        answers = setAnswers(new String[]{"gone with the wind","gwtw"});
        addQuestion(new Question("\"Frankly, my dear, I don't give a damn.\"",
                answers,4,2,5,0));


        answers = setAnswers(new String[]{"on the waterfront","waterfront"});
        addQuestion(new Question("\"You don't understand! I coulda had class. I coulda been a contender. I could've been somebody, instead of a bum, which is what I am.\"",
                answers,1,2,7,0));

        answers = setAnswers(new String[]{"wizard of oz","the wizard of oz"});
        addQuestion(new Question("\"Toto, I've got a feeling we're not in Kansas anymore.\"",
                answers,1,2,9,0));

        answers = setAnswers(new String[]{"casablanca"});
        addQuestion(new Question("\"Here's looking at you, kid.\"",
                answers,3,2,5,0));

        answers = setAnswers(new String[]{"sunset boulevard"});
        addQuestion(new Question("\"All right, Mr. DeMille, I'm ready for my close-up.\"",
                answers,2,2,5,0));

        answers = setAnswers(new String[]{"gangster squad"});
        addQuestion(new Question("\"You talking to God Mitch, so you might as well swear to me\"",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"all about eve"});
        addQuestion(new Question("\"Fasten your seatbelts. It's going to be a bumpy night.\"",
                answers,2,2,5,0));

        answers = setAnswers(new String[]{"hand luke"});
        addQuestion(new Question("\"What we've got here is failure to communicate.\"",
                answers,4,2,5,0));

        answers = setAnswers(new String[]{"maltese falcon","the maltese falcon"});
        addQuestion(new Question("\"The stuff that dreams are made of.\"",
                answers,2,2,7,0));

        answers = setAnswers(new String[]{"e.t the extra-terrestrial","e.t","e.t the extra terrestrial"});
        addQuestion(new Question("\"E.T. phone home.\"",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"in the heat of the night"});
        addQuestion(new Question("\"They call me Mister Tibbs!\"",
                answers,3,2,10,0));

        answers = setAnswers(new String[]{"white heat"});
        addQuestion(new Question("\"Made it, Ma! Top of the world!\"",
                answers,3,2,5,0));

        answers = setAnswers(new String[]{"network","the network"});
        addQuestion(new Question("\"I'm as mad as hell, and I'm not going to take this anymore!\"",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"sunset boulevard"});
        addQuestion(new Question("\"I am big! It's the pictures that got small.\"",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"she done him wrong"});
        addQuestion(new Question("\"Why don't you come up sometime and see me?\"",
                answers,2,2,5,0));

        answers = setAnswers(new String[]{"casablanca"});
        addQuestion(new Question("\"Play it, Sam. Play 'As Time Goes By.'\"",
                answers,2,2,5,0));

        answers = setAnswers(new String[]{"pride of the yankees","the pride of the yankees"});
        addQuestion(new Question("\"Today, I consider myself the luckiest man on the face of the earth.\"",
                answers,4,2,6,0));

        answers = setAnswers(new String[]{"field of dreams"});
        addQuestion(new Question("\"If you build it, he will come.\"",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"now, voyager","now voyager"});
        addQuestion(new Question("\"Oh, Jerry, don't let's ask for the moon. We have the stars.\"",
                answers,2,2,10,0));

        answers = setAnswers(new String[]{"jerry meguire"});
        addQuestion(new Question("\"You had me at? hello.?\"",
                answers,3,2,5,0));

        answers = setAnswers(new String[]{"annie hall"});
        addQuestion(new Question("\"La-dee-da, la-dee-da.\"",
                answers,4,2,8,0));

        answers = setAnswers(new String[]{"wall street"});
        addQuestion(new Question("\"Greed, for lack of a better word, is good.\"",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"gone with the wind","gwtw"});
        addQuestion(new Question("\"As God is my witness, I'll never be hungry again.\" ",
                answers,3,2,9,0));

        answers = setAnswers(new String[]{"sons of the desert"});
        addQuestion(new Question("\"Well, here's another nice mess you've gotten me into!\"",
                answers,2,2,5,0));

        answers = setAnswers(new String[]{"adventures of sherlock holmes","sherlock holmes"});
        addQuestion(new Question("\"Elementary, my dear Watson.\"",
                answers,4,2,9,0));

        answers = setAnswers(new String[]{"little caesar"});
        addQuestion(new Question("\"Mother of mercy, is this the end of Rico?\"",
                answers,2,2,9,0));

        answers = setAnswers(new String[]{"chinatown"});
        addQuestion(new Question("\"Forget it, Jake, it's Chinatown.\"",
                answers,1,2,9,0));

        answers = setAnswers(new String[]{"a streetcar named desire","streetcar named desire"});
        addQuestion(new Question("\"I have always depended on the kindness of strangers.\"",
                answers,3,2,5,0));

        answers = setAnswers(new String[]{"airplane"});
        addQuestion(new Question("\"Surely you can't be serious.\"\n\"I am serious?and don't call me Shirley.\"",
                answers,2,2,10,0));

        answers = setAnswers(new String[]{"king kong"});
        addQuestion(new Question("\"Oh, no, it wasn't the airplanes. It was Beauty killed the Beast.\"",
                answers,3,2,8,0));

        answers = setAnswers(new String[]{"on golden pond","golden pond"});
        addQuestion(new Question("\"Listen to me, mister. You're my knight in shining armor. Don't you forget it. \n" +
                "You're going to get back on that horse, and \n" +
                "I'm going to be right behind you, holding on tight, \n" +
                "and away we're gonna go, go, go!\"",
                answers,2,2,8,0));

        answers = setAnswers(new String[]{"knut rockne all american"});
        addQuestion(new Question("\"Tell 'em to go out there with all they got and win just one for the Gipper.\"",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"caddyshack"});
        addQuestion(new Question("\"Cinderella story. Outta nowhere. A former\n" +
                "greenskeeper, now, about to become the Masters champion.\n" +
                "It looks like a mirac...It's in\n" +
                "the hole! It's in the hole! It's in the hole!\"",
                answers,4,2,8,0));

        answers = setAnswers(new String[]{"dead poets society"});
        addQuestion(new Question("\"Carpe diem. Seize the day, boys. Make your lives extraordinary.\"",
                answers,3,2,5,0));

        answers = setAnswers(new String[]{"yankee doodle dandy"});
        addQuestion(new Question("\"My mother thanks you. My father thanks you. My sister thanks you. And I thank you.\"",
                answers,1,2,7,0));

        answers = setAnswers(new String[]{"wizard of oz","the wizard of oz"});
        addQuestion(new Question("\"I'll get you, my pretty, and your little dog, too!\"",
                answers,3,2,6,0));

        answers = setAnswers(new String[]{"broke back"});
        addQuestion(new Question("\"I wish I knew how to quit you\"",
                answers,2,2,8,0));

        answers = setAnswers(new String[]{"there will be blood"});
        addQuestion(new Question("\"I drink your milkshake\"",
                answers,1,2,9,0));

        answers = setAnswers(new String[]{"vvitch","witch","the vvitch","the witch"});
        addQuestion(new Question("\"Wouldst thou like to live deliciously?\" ",
                answers,4,2,10,0));

        answers = setAnswers(new String[]{"bicycle thieves"});
        addQuestion(new Question("\"Why should I kill myself worrying when I'll end up \n" +
                "just as dead?\"",
                answers,2,2,5,0));

        answers = setAnswers(new String[]{"parasite"});
        addQuestion(new Question("\"You know what kind of plan never fails? No plan. \n" +
                "No plan at all. You know why? Because life cannot \n" +
                "be planned.\"",
                answers,2,2,5,0));

        answers = setAnswers(new String[]{"requiem for a dream"});
        addQuestion(new Question("\"Ah, it's not the same. They don't need me. I like the way I feel. I like \n" +
                "thinking about the red dress and the television and you and your father. Now when \n" +
                "I get the sun, I smile.\"",
                answers,2,2,5,0));

        answers = setAnswers(new String[]{"usual suspects"});
        addQuestion(new Question("\"The greatest trick the devil ever pulled was to convince the world he didn't exist\"",
                answers,4,2,8,0));

        answers = setAnswers(new String[]{"good morning vietnam"});
        addQuestion(new Question("\"Gooooooooooooooooooooood moring Vietnaaaam!\"",
                answers,1,2,8,0));

        answers = setAnswers(new String[]{"who framed roger rabbit"});
        addQuestion(new Question("\"Iam not bad iam just drawn this way\"",
                answers,2,2,10,0));

        answers = setAnswers(new String[]{"karate kid"});
        addQuestion(new Question("\" Wax on right hand, Wax off left hand, Wax on, Wax off\"",
                answers,3,2,9,0));

        answers = setAnswers(new String[]{"gladiator","the gladiator"});
        addQuestion(new Question("\"My name is Maximus Decimus Meridius, Commander of the Armies of the North, General of the \n" +
                "Felix Legions, loyal servant to the true emperor, Marcus Aurelius. Father to a murdered son, \n" +
                "husband to a murdered wife. And I will have my vengeance, in this life or the next.\"",
                answers,2,2,5,0));

        answers = setAnswers(new String[]{"mad max: fury road","mad max", "mad max fury road"});
        addQuestion(new Question("\"I live, I die. I LIVE AGAIN!\"",
                answers,3,2,9,0));

        answers = setAnswers(new String[]{"whiplash"});
        addQuestion(new Question("\"I was there to push people beyond what's expected of them\"",
                answers,4,2,8,0));

        answers = setAnswers(new String[]{"whiplash"});
        addQuestion(new Question("\"There are no two words in the English language more harmful than \"good job\".\"",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"leon the professional"});
        addQuestion(new Question("\"Its when you really start to fear death that you learn to appreciate life.\"",
                answers,3,2,5,0));

        answers = setAnswers(new String[]{"leon the professional"});
        addQuestion(new Question("\"Is life always this hard, or is it just when you're a kid\"\n" +
                "\"Always\"",
                answers,2,2,7,0));

        answers = setAnswers(new String[]{"the lion king","lion king"});
        addQuestion(new Question("\"I'am surrounded by idiots\"",
                answers,1,2,7,0));

        answers = setAnswers(new String[]{"american psycho"});
        addQuestion(new Question("\"I believe in taking care of myself, in \n" +
                "a balanced diet, in a rigorous exercise routine.\n" +
                "In the morning, if my face is a little puffy, I'll \n" +
                "put on an  icepack while doing my stomach crunches.\n" +
                "I can do a thousand now. After I remove the icepack, \n" +
                "I use a deep-pore cleanser lotion. In The shower...\"",
                answers,4,2,5,0));

        answers = setAnswers(new String[]{"the pink panther","pink panther"});
        addQuestion(new Question("\"I would like to buy a hamburger\"",
                answers,2,2,7,0));

        answers = setAnswers(new String[]{"meet joe black"});
        addQuestion(new Question("\"There's no sense living your life without this.\n" +
                "To make the journey and not fall deeply in love, \n" +
                "well, you haven't lived a life at all. But you have\n" +
                "to try, cause if you haven't tried, you haven't lived.\"",
                answers,1,2,10,0));

        answers = setAnswers(new String[]{"how the grinch stole christmas","the grinch"});
        addQuestion(new Question("\"It came without ribbons, it came without tags.\n" +
                "It came without packages, boxes, or bags.\"",
                answers,3,2,8,0));

        answers = setAnswers(new String[]{"ocean's eleven","oceans eleven","oceans 11","ocean's 11"});
        addQuestion(new Question("\"Terry, you of all people should know, in your hotel,\n" +
                "there's always someone watching.\"",
                answers,2,2,6,0));

        answers = setAnswers(new String[]{"fear and loathing in las vegas"});
        addQuestion(new Question("\"I'm a relatively respectable citizen. Multiple felon \n" +
                "perhaps, but certainly not dangerous\"",
                answers,3,2,9,0));

        answers = setAnswers(new String[]{"ted"});
        addQuestion(new Question("\"Why are you crying?\"\n" +
                "\"My d**k is squished by the TV.\"",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"da vinci code","the da vinci code"});
        addQuestion(new Question("\"Men go to far greater lengths to avoid what they\n" +
                "fear than to obtain what they desire.\"",
                answers,4,2,8,0));

        answers = setAnswers(new String[]{"casino royale"});
        addQuestion(new Question("\"I'm sorry. That last hand... nearly killed me.\"",
                answers,2,2,7,0));

        answers = setAnswers(new String[]{"casino"});
        addQuestion(new Question("\"You put my f***in' money to sleep. You go get my\n" +
                "money or I'll put your f***in' brain to sleep!\"",
                answers,3,2,5,0));


        answers = setAnswers(new String[]{"casino"});
        addQuestion(new Question("\"There's three ways to do things, the right way,\n" +
                "the wrong way and the way that i do it\"",
                answers,1,2,9,0));

        answers = setAnswers(new String[]{"suicide squad","the suicide squad"});
        addQuestion(new Question("\"Huh? What was that? I should kill everyone and escape?\n" +
                "Sorry. The voices.\n" +
                "I'm kidding! Jeez! That's not what they really said.\"",
                answers,2,2,5,0));

        answers = setAnswers(new String[]{"the prestige","prestige"});
        addQuestion(new Question("\"Man's reach exceeds his imagination!\"",
                answers,3,2,10,0));

        answers = setAnswers(new String[]{"notebook","the notebook"});
        addQuestion(new Question("\"I am nothing special, of this I am sure. I am a common\n" +
                "man with common thoughts and I've led a common life. There are\n" +
                "no monuments dedicated to me and my name will soon be forgotten,\n" +
                "but I've loved another with all my heart and soul,\n" +
                "and to me, this has always been enough..\"",
                answers,4,2,5,0));

        answers = setAnswers(new String[]{"hugo"});
        addQuestion(new Question("\"This might be an adventure, and I've never had one before - outside of books, at least.\"",
                answers,1,2,8,0));

        answers = setAnswers(new String[]{"green mile","the green mile"});
        addQuestion(new Question("\"Please boss, don't put that thing over my face, don't put me in the dark. I's afraid of the dark.\"",
                answers,2,2,9,0));

        answers = setAnswers(new String[]{"the green mile","green mile"});
        addQuestion(new Question("\"He kill them wi' their love. Wi' their love fo' each other.\n" +
                "That's how it is, every day, all over the world.\"",
                answers,1,2,6,0));

        answers = setAnswers(new String[]{"independence day"});
        addQuestion(new Question("\"Look at us. Everybody's trying to get out of Washington, and we're the only schmucks trying to get in.\"",
                answers,3,2,9,0));

        answers = setAnswers(new String[]{"the dark knight","dark knight"});
        addQuestion(new Question("\"Where is she!?\"",
                answers,3,2,6,0));

        answers = setAnswers(new String[]{"inception"});
        addQuestion(new Question("\"You musn't be afraid to dream a little bigger darling.\"",
                answers,4,2,7,0));

        answers = setAnswers(new String[]{"inception"});
        addQuestion(new Question("\"An idea is like a virus. Resilient. Highly contagious. And even the smallest\n" +
                "seed of an idea can grow. It can grow to define or destroy you.\"",
                answers,4,2,10,0));

        answers = setAnswers(new String[]{"fifth element","the fifth element","the 5th element","5th element"});
        addQuestion(new Question("\"You wanna play it soft. We'll play it soft. You wanna play it hard. Let's play it hard.\"",
                answers,1,2,8,0));

        answers = setAnswers(new String[]{"fifth element","the fifth element","the 5th element","5th element"});
        addQuestion(new Question("\"Bzzzzzzzzzzzzzzzzzt!\"",
                answers,2,2,10,0));

        answers = setAnswers(new String[]{"armageddon"});
        addQuestion(new Question("\"Hey, guys, remember: we're, we're heroes now. So that incident with me and the gun on the asteroid. Let`s keep that under wraps, all right!\"",
                answers,3,2,10,0));

        answers = setAnswers(new String[]{"armageddon"});
        addQuestion(new Question("\"What's up Harry? Did N.A.S.A. find oil on Uranus? Man.\"",
                answers,2,2,10,0));

        answers = setAnswers(new String[]{"the martian","martian"});
        addQuestion(new Question("\"I am definitely going to die up here ... if I have to listen to any more god-awful disco music.\"",
                answers,1,2,8,0));

        answers = setAnswers(new String[]{"the martian","martian"});
        addQuestion(new Question("\"I admit it's fatally dangerous, but I'd get to fly around like Iron Man.\"",
                answers,2,2,6,0));

        answers = setAnswers(new String[]{"star is born","a star is born"});
        addQuestion(new Question("\"How you doin', papo?\n" +
                "How am I doing? I'm doing all right if I can get a f***ing drink.\"",
                answers,3,2,9,0));

        answers = setAnswers(new String[]{"american pie"});
        addQuestion(new Question("\"I have to admit, you know, I did the fair bit of masturbating when I was\n" +
                "a little younger. I used to call it stroking the salami, yeah, you\n" +
                "know, pounding the old pud. I never did it with baked goods, but you \n" +
                "know your uncle Mort, he pets the one-eyed snake 5-6 times a day.\"",
                answers,2,2,7,0));

        answers = setAnswers(new String[]{"project x"});
        addQuestion(new Question("\"Costaaaaaaaaaa! Give me back my fucking gnome!\"",
                answers,1,2,9,0));

        answers = setAnswers(new String[]{"22 jump street","jump street"});
        addQuestion(new Question("\"Dude, I'm so sorry for being a homophone\"",
                answers,3,2,8,0));

        answers = setAnswers(new String[]{"project x"});
        addQuestion(new Question("\"The only thing your working on is diabetes you fat f**k.\"",
                answers,4,2,10,0));

        answers = setAnswers(new String[]{"22 jump street","jump street"});
        addQuestion(new Question("\"My name's Jeff...\"",
                answers,2,2,5,0));

        answers = setAnswers(new String[]{"straight outta compton"});
        addQuestion(new Question("\"She kinda... preoccupied wit some real ni**a d**k\"",
                answers,4,2,9,0));

        answers = setAnswers(new String[]{"tropic thunder"});
        addQuestion(new Question("\"You went full retard man, never go full retard.\"",
                answers,1,2,8,0));

        answers = setAnswers(new String[]{"tropic thunder"});
        addQuestion(new Question("\"Man were lost, were super lost!\"",
                answers,2,2,10,0));

        answers = setAnswers(new String[]{"space jam"});
        addQuestion(new Question("\"C'mon Michael it's Game Time. Get your Hanes on, lace up your Nike's, grab your\n" +
                "Weaties and your Gatorade, and we'll pick up a Big Mac on the way to the ballpark.\"",
                answers,4,2,7,0));

        answers = setAnswers(new String[]{"coach carter"});
        addQuestion(new Question("\"You said we're a team. One person struggles, we all struggle. One person triumphs, we all triumph.\"",
                answers,1,2,9,0));

        answers = setAnswers(new String[]{"i am legend"});
        addQuestion(new Question("\"The people who are trying to make the world worse are not taking a day off. How can I? Light up the darkness.\"",
                answers,3,2,8,0));

        answers = setAnswers(new String[]{"the pirate's of the caribbean","the pirates of the caribbean","pirates of the caribbean","pirate's of the caribbean"});
        addQuestion(new Question("\"That's Gotta be the Best Pirate I've Ever Seen\"",
                answers,4,2,7,0));

        answers = setAnswers(new String[]{"transporter","the transporter"});
        addQuestion(new Question("\"Rule 1: Never change the deal.\n" +
                "Rule 2: No names.\n" +
                "Rule 3: Never open the package.\"",
                answers,1,2,7,0));

        answers = setAnswers(new String[]{"it"});
        addQuestion(new Question("\"You punched me, made me walk through shitty water, dragged me through\n" +
                "a crackhouse... and now I'm gonna have to kill this f***ing clown.\"",
                answers,2,2,8,0));

        // total Hard questions : 100

        answers = setAnswers(new String[]{"penguins of madagascar"});
        addQuestion(new Question("\"Just smile and wave boys...smile and wave...\"",
                answers,1,2,6,0));

        answers = setAnswers(new String[]{"the godfather","godfather"});
        addQuestion(new Question("\"I'm going to make him an offer he can't refuse.\"",
                answers,2,2,7,0));

        answers = setAnswers(new String[]{"star wars","star wars: episode 5","star wars episode 5","star wars episode v","star wars: episode v"});
        addQuestion(new Question("\"May the Force be with you.\"",
                answers,2,2,5,0));

        answers = setAnswers(new String[]{"taxi driver"});
        addQuestion(new Question("\"You talking to me?\"",
                answers,4,2,5,0));

        answers = setAnswers(new String[]{"apocalypse now"});
        addQuestion(new Question("\"I love the smell of napalm in the morning.\"",
                answers,3,2,5,0));

        answers = setAnswers(new String[]{"love story"});
        addQuestion(new Question("\"Love means never having to say you're sorry.\"",
                answers,1,2,9,0));

        answers = setAnswers(new String[]{"casablanca"});
        addQuestion(new Question("\"Louis, I think this is the beginning of a beautiful friendship.\"",
                answers,1,2,6,0));

        answers = setAnswers(new String[]{"silence of the lambs","the silence of the lambs"});
        addQuestion(new Question("\"A census taker once tried to test me. I ate his liver with some fava beans and a nice Chianti.\"",
                answers,2,2,7,0));

        answers = setAnswers(new String[]{"dr.no"});
        addQuestion(new Question("\"Bond. James Bond.\"",
                answers,1,2,10,0));

        answers = setAnswers(new String[]{"wizard of oz","the wizard of oz"});
        addQuestion(new Question("\"There's no place like home.\" ",
                answers,4,2,6,0));

        answers = setAnswers(new String[]{"jerry meguire"});
        addQuestion(new Question("\"Show me the money!\"",
                answers,3,2,8,0));

        answers = setAnswers(new String[]{"midnight cowboy"});
        addQuestion(new Question("\"I'm walking here! I'm walking here!\"",
                answers,3,2,8,0));

        answers = setAnswers(new String[]{"a few good man","few good man"});
        addQuestion(new Question("\"You can't handle the truth!\"",
                answers,2,2,6,0));

        answers = setAnswers(new String[]{"gone with the wind","gwtw"});
        addQuestion(new Question("\"After all, tomorrow is another day!\"",
                answers,1,2,7,0));

        answers = setAnswers(new String[]{"when hatty met sally"});
        addQuestion(new Question("\"I'll have what she's having.\"",
                answers,4,2,10,0));

        answers = setAnswers(new String[]{"jaws"});
        addQuestion(new Question("\"You're gonna need a bigger boat.\"",
                answers,1,2,7,0));

        answers = setAnswers(new String[]{"the terminator","terminator"});
        addQuestion(new Question("\"I'll be back.\"",
                answers,4,2,5,0));

        answers = setAnswers(new String[]{"furious 7"});
        addQuestion(new Question("\"I don't have friends, I got family\"",
                answers,4,2,5,0));

        answers = setAnswers(new String[]{"forrest gump"});
        addQuestion(new Question("\"Mama always said life was like a box of chocolates. You never know what you're gonna get.\"",
                answers,2,2,5,0));

        answers = setAnswers(new String[]{"bonnie and clyde"});
        addQuestion(new Question("\"We rob banks.\"",
                answers,3,2,5,0));

        answers = setAnswers(new String[]{"the sixth sense","sixsth sense","the 6th sense","6th sense"});
        addQuestion(new Question("\"I see dead people.\" ",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"iron man"});
        addQuestion(new Question("\"I am Iron Man\"",
                answers,3,2,5,0));

        answers = setAnswers(new String[]{"frankenstein"});
        addQuestion(new Question("\"It's alive! It's alive!\"",
                answers,2,2,5,0));

        answers = setAnswers(new String[]{"apollo 13"});
        addQuestion(new Question("\"Houston, we have a problem.\"",
                answers,3,2,5,0));

        answers = setAnswers(new String[]{"dirty harry"});
        addQuestion(new Question("\"You've got to ask yourself one question: 'Do I feel lucky?' Well, do ya, punk?\" ",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"psycho"});
        addQuestion(new Question("\"A boy's best friend is his mother.\" ",
                answers,4,2,5,0));

        answers = setAnswers(new String[]{"animal crackers"});
        addQuestion(new Question("\"One morning I shot an elephant in my pajamas. How he got in my pajamas, I don't know.\" ",
                answers,4,2,5,0));

        answers = setAnswers(new String[]{"a league of their own","league of the own"});
        addQuestion(new Question("\"There's no crying in baseball!\"",
                answers,3,2,8,0));

        answers = setAnswers(new String[]{"the godfather","godfather","the godfather part 2","the godfather 2","godfather 2","godfather part 2"});
        addQuestion(new Question("\"Keep your friends close, but your enemies closer.\"",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"scarface"});
        addQuestion(new Question("\"Say \"hello\" to my little friend!\"",
                answers,2,2,5,0));

        answers = setAnswers(new String[]{"graduate","the graduate"});
        addQuestion(new Question("\"Mrs. Robinson, you're trying to seduce me. Aren't you?\"",
                answers,3,2,5,0));

        answers = setAnswers(new String[]{"dawn of the planet of the apes","planet of the apes","the planet of the apes"});
        addQuestion(new Question("\"Apes together strong!... Caesar weak!\" \n" +
                "\"Koba weaker.\"",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"dr. strangelove"});
        addQuestion(new Question("\"Gentlemen, you can't fight in here! This is the War Room!\"",
                answers,4,2,5,0));

        answers = setAnswers(new String[]{"the matrix","matrix"});
        addQuestion(new Question("\"I know kung fu\"",
                answers,2,2,5,0));

        answers = setAnswers(new String[]{"planet of the apes","the planet of the apes"});
        addQuestion(new Question("\"Get your stinking paws off me, you damned dirty ape.\"",
                answers,4,2,5,0));

        answers = setAnswers(new String[]{"the shining","shining"});
        addQuestion(new Question("\"Here's Johnny!\"",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"jazz singer","the jazz singer"});
        addQuestion(new Question("\"Wait a minute, wait a minute. You ain't heard nothin' yet!\"",
                answers,4,2,9,0));

        answers = setAnswers(new String[]{"avengers","the avengers","avengers: age of ultron","the avengers: age of ultron","the avengers age of ultron","avengers age of ultron"});
        addQuestion(new Question("\"There are no strings on me\"",
                answers,2,2,9,0));

        answers = setAnswers(new String[]{"cars"});
        addQuestion(new Question("\"Ka-Chow\"",
                answers,2,2,5,0));

        answers = setAnswers(new String[]{"terminator","the terminator"});
        addQuestion(new Question("\"Hasta la vista, baby.\"",
                answers,3,2,5,0));

        answers = setAnswers(new String[]{"rocky"});
        addQuestion(new Question("\"Yo, Adrian!\"",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"the matrix","matrix"});
        addQuestion(new Question("\"Mr. Anderson\"",
                answers,4,2,5,0));

        answers = setAnswers(new String[]{"dracula"});
        addQuestion(new Question("\"Listen to them. Children of the night. What music they make.\"",
                answers,4,2,5,0));

        answers = setAnswers(new String[]{"lord of the rings","lotr","the lord of the rings","lord of the rings two towers","the lord of the rings two towers","lord of the rings the two towers","lord of the rings: two towers","lord of the rings two towers"});
        addQuestion(new Question("\"My precious.\"",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"spider-man","spider man"});
        addQuestion(new Question("\"You Know i'm something of a scientist myself \"",
                answers,3,2,5,0));

        answers = setAnswers(new String[]{"goldfinger"});
        addQuestion(new Question("\"A martini. Shaken, not stirred.\"",
                answers,2,2,5,0));

        answers = setAnswers(new String[]{"top gun"});
        addQuestion(new Question("\"I feel the need - the need for speed!\"",
                answers,4,2,7,0));

        answers = setAnswers(new String[]{"dirty dancing"});
        addQuestion(new Question("\"Nobody puts Baby in a corner.\" ",
                answers,1,2,10,0));

        answers = setAnswers(new String[]{"titanic"});
        addQuestion(new Question("\"I'm king of the world!\"",
                answers,3,2,6,0));

        answers = setAnswers(new String[]{"gladiator","the gladiator"});
        addQuestion(new Question("\"Are you not entertained?\"",
                answers,1,2,7,0));

        answers = setAnswers(new String[]{"finding nemo"});
        addQuestion(new Question("\"Just keep swimming\"",
                answers,1,2,9,0));

        answers = setAnswers(new String[]{"no country for old men"});
        addQuestion(new Question("\"What's the most you ever lost on a coin toss?\"",
                answers,4,2,5,0));

        answers = setAnswers(new String[]{"the dark knight","dark knight"});
        addQuestion(new Question("\"Why so serious?\"",
                answers,3,2,5,0));

        answers = setAnswers(new String[]{"the dark knight","dark knight"});
        addQuestion(new Question("\"If your good at something never do it for free\"",
                answers,2,2,5,0));

        answers = setAnswers(new String[]{"the social network","social network"});
        addQuestion(new Question("\"A million dollars isn't cool. You know what's cool? \n" +
                "A billion dollars.\"",
                answers,3,2,5,0));

        answers = setAnswers(new String[]{"blade runner","the blade runner"});
        addQuestion(new Question("\"I've seen things you people wouldn't believe. \n" +
                "Attack ships on fire off the shoulder of Orion. I \n" +
                "watched C-beams glitter in the dark near the \n" +
                "Tannhuser Gate. All those moments will be lost in \n" +
                "time, like tears in rain. Time to die.\"",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"requiem for a dream"});
        addQuestion(new Question("\"Ah, it's not the same. They don't need me. I like the way I feel. I like \n" +
                "thinking about the red dress and the television and you and your father. Now when \n" +
                "I get the sun, I smile.\"",
                answers,2,2,5,0));

        answers = setAnswers(new String[]{"requiem for a dream"});
        addQuestion(new Question("\"Purple in the morning, blue in the afternoon, orange in the evening\"",
                answers,3,2,5,0));

        answers = setAnswers(new String[]{"usual suspects","the usual suspects"});
        addQuestion(new Question("\"The greatest trick the devil ever pulled was to convince the world he didn't exist\"",
                answers,4,2,5,0));

        answers = setAnswers(new String[]{"back to the future"});
        addQuestion(new Question("\"Roads...Where we are going we don't need roads\"",
                answers,3,2,5,0));

        answers = setAnswers(new String[]{"star wars"});
        addQuestion(new Question("\"I am your father\"",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"braveheart"});
        addQuestion(new Question("\"They may take our lives but they will never take our freedom\"",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"fight club"});
        addQuestion(new Question("\"The fist rule of.... is you never talk about ... The second rule of .....\"",
                answers,4,2,5,0));

        answers = setAnswers(new String[]{"die hard"});
        addQuestion(new Question("\"Yippee-Ki-Yay, Motherf*cker!\"",
                answers,2,2,5,0));

        answers = setAnswers(new String[]{"good will hunting"});
        addQuestion(new Question("\"How You Like Them Apples?\"",
                answers,2,2,5,0));

        answers = setAnswers(new String[]{"aladdin"});
        addQuestion(new Question("\"You have never had a friend like me!!\"",
                answers,3,2,10,0));

        answers = setAnswers(new String[]{"dazed and confused"});
        addQuestion(new Question("\"Alright, Alright, Alright\"",
                answers,3,2,9,0));

        answers = setAnswers(new String[]{"300"});
        addQuestion(new Question("\"This is Sparta!!!\"",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"lord of the rings","lotr","the lord of the rings"});
        addQuestion(new Question("\"You shall not pass!!\"",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"predator","the predator"});
        addQuestion(new Question("\"Get to the choppa!!! \"",
                answers,3,2,5,0));

        answers = setAnswers(new String[]{"toy story"});
        addQuestion(new Question("\"To infinity and beyond\"",
                answers,4,2,5,0));

        answers = setAnswers(new String[]{"seven","7","se7en"});
        addQuestion(new Question("\"Aaaa Whats in the box... whats in the f**king box!?\"",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"mad max: fury road","mad max","mad max fury road"});
        addQuestion(new Question("\"Oh, what a day... what a lovely day!\"",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"mad max","mad max: fury road","mad max fury road","mad max:fury road"});
        addQuestion(new Question("\"I live, I die. I LIVE AGAIN!\"",
                answers,3,2,9,0));

        answers = setAnswers(new String[]{"harry potter"});
        addQuestion(new Question("\"Its leviOsa not levioSA\"",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"gladiator","the gladiator"});
        addQuestion(new Question("\"Death smiles at us all. All a man can do is smile back \"",
                answers,2,2,5,0));

        answers = setAnswers(new String[]{"pulp fiction"});
        addQuestion(new Question("\"English motherf**ker, do you speak it?\"",
                answers,3,2,5,0));

        answers = setAnswers(new String[]{"whiplash"});
        addQuestion(new Question("\"There are no two words in the English language more harmful than \"good job\".\"",
                answers,1,2,10,0));

        answers = setAnswers(new String[]{"harry potter"});
        addQuestion(new Question("\"Always\"",
                answers,4,2,7,0));

        answers = setAnswers(new String[]{"v for vendetta"});
        addQuestion(new Question("\"Voila! In view humble vaudevillian veteran, cast vicariously as both victim and villain\n" +
                "by the vicissitudes of fate. This visage, no mere veneer of vanity, is a vestige\n" +
                "of the “vox populi” now vacant, vanished. However, this valorous visitation of a bygone vexation\n" +
                "stands vivified, and has vowed to vanquish...\"",
                answers,3,2,5,0));

        answers = setAnswers(new String[]{"8 mile","eight mile"});
        addQuestion(new Question("\"F**k the beat, I'll go a capella! F**k a Papa Doc, \n" +
                "f**k a clock, f**k a trailer, f**k everybody! F**k y'all if\n" +
                "you doubt me! I'm a piece of f**king white trash, I say it proudly! And \n" +
                "f**k this battle, I don't wanna win, i'm outtie. \n" +
                "Here, tell these people something they don't know about me.\"",
                answers,4,2,8,0));

        answers = setAnswers(new String[]{"superbad"});
        addQuestion(new Question("\"I am McLovin!\"",
                answers,1,2,7,0));


        answers = setAnswers(new String[]{"tropic thunder"});
        addQuestion(new Question("\"I'm the Dude, playing a dude, disguised as another dude!\"",
                answers,3,2,5,0));


        answers = setAnswers(new String[]{"space jam"});
        addQuestion(new Question("\"But mommy, I don't want to go to school today. I want to stay home and bake cookies with you!\"",
                answers,4,2,9,0));

        answers = setAnswers(new String[]{"saw"});
        addQuestion(new Question("\"Do you want to play a game?\"",
                answers,4,2,10,0));

        answers = setAnswers(new String[]{"scream"});
        addQuestion(new Question("\"Do you like scary movies?\"",
                answers,2,2,6,0));

        answers = setAnswers(new String[]{"dracula"});
        addQuestion(new Question("\"I never drink...wine.\"",
                answers,1,2,10,0));

        answers = setAnswers(new String[]{"get out"});
        addQuestion(new Question("\"By The Way, I Would Have Voted For Obama For A Third Term, If I Could.\"",
                answers,3,2,8,0));

        answers = setAnswers(new String[]{"the departed","departed"});
        addQuestion(new Question("\"I'm gonna go have a smoke right now. You want a smoke? You don't smoke, do ya, right? \n" +
                "What are ya, one of those fitness freaks, huh? Go f**k yourself.\"",
                answers,1,2,6,0));

        answers = setAnswers(new String[]{"memento"});
        addQuestion(new Question("\"Enter OK, so what am I doing?\n" +
                "Oh, I'm chasing this guy.\n" +
                "No, he's chasing me.\"",
                answers,2,2,9,0));

        answers = setAnswers(new String[]{"alien"});
        addQuestion(new Question("\"If we ain't out of here in ten minutes, we won't need no rocket to fly through space!\"",
                answers,3,2,10,0));

        answers = setAnswers(new String[]{"full metal jacket","FMJ"});
        addQuestion(new Question("\"Well here`s something you won`t like, Private Snowball! They don`t serve \n" +
                "fried chicken and watermelon down in the mess hall every day!\"",
                answers,1,2,5,0));


        answers = setAnswers(new String[]{"game of thrones","got"});
        addQuestion(new Question("\"That's what i do drink and know things\"",
                answers,4,2,5,0));

        answers = setAnswers(new String[]{"the boys"});
        addQuestion(new Question("\"F**king Diabolical\"",
                answers,1,2,5,0));

        answers = setAnswers(new String[]{"breaking bad"});
        addQuestion(new Question("\"I am the danger. A guy opens his door and gets shot, and you think that of me? \n" +
                "No! I am the one who knocks!\"",
                answers,2,2,5,0));
    }
}
