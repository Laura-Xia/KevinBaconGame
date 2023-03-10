import java.util.Scanner;

public class TextGame {
	public static Scanner s = new Scanner(System.in);
	public static String name;
	public static void getName() {
		System.out.println("What should we call you: ");
		name=s.nextLine();
		start();
	}
	public static void start() {
		System.out.println("You wake up in the morning and realize you have entered a parallel universe where you are the owner of a fairly successful business. \n\n");
		System.out.println("Confused, you decide to...\n\n");
		System.out.println("a. Take up your new role.\n");
		System.out.println("b. Resign, this responsibility is too big for you.\n");
		String input=s.nextLine();
		if(input.equals("a")) take();
		else if(input.equals("b")) resign();
		else error();
	}
	public static void resign() {
		System.out.println("You decide to resign from your job and live a peaceful life.\n\n");
		System.out.println("After sending an email informing your employees that you have resigned, you turn on the tap to get some water for yourself to drink. However, the water seems a little cloudy.\n\n");
		System.out.println("You suddenly remember that in this universe, the lake in your town, which happens to be your town's residents water source, has been contaminated by the factories surrounding it.\n\n");
		System.out.println("Worried about the health of you and your fellow residents who are living off this polluted water, you decide to...\n\n");
		System.out.println("a. Do some research and figure out what is causing your town's lake to be so polluted.\n");
		System.out.println("b. Ignore the problem, you won't die just from drinking some cloudy water, plus what can you do to stop the pollution?\n");
		String input=s.nextLine();
		if(input.equals("a")) research();
		else if(input.equals("b")) ignore();
		else error();
	}
	public static void ignore() {
		System.out.println("You decide to ignore the problem and drink the rather cloudy water anyways. \n\n");
		System.out.println("Suddenly, you phone starts ringing, and it's a call from your aunt who has not contacted you in anyway for at least twenty years. Doubtful as to why she called, you decide to...\n\n");
		System.out.println("a. Hang up. There is no reason for her to call, and plus you, being socially anxious as you are, do not want to talk to random people.\n");
		System.out.println("b. Pick up. Let's just see what she wants to say.\n");
		String input=s.nextLine();
		if(input.equals("a")) hang();
		else if(input.equals("b")) pick();
		else error();
	}
	public static void hang() {
		System.out.println("You decide to hang up on your aunt and enjoy your cup of water. After that you left the house and hang out with some friends you have here in this universe. After playing golf with them, you feel like you are enjoying life here and are blending in pretty well.\n\n");
		System.out.println("Having worked as the owner of your former business for ten years already, you have a significant fortune in your bank. This is enough to enable you to live a life of playing golf with your friends daily without doing any work. Maybe you will have fun forever until you pass away peacefully at the age of eighty or ninety...\n\n");
		System.out.println("However, things don't always go the way you wish they will go. At the age of 43, you suddenly develope diarrhoea. You had this issue as a kid, so at first you do not think much of it. However, as time goes on your diarrhoea does not seem to get better. Weeks after weeks you have to sat on the toilet for hours after hours, and even worse, you started vomitting and lossing sleep.\n\n");
		System.out.println("You finally become scared and decide to go to local hospital in your town. The doctos give you some diagnosis and conclude that you have been infected with cholera.\n\n");
		System.out.println("Panicked, you plead the doctors to save you. Cholera should be relatively simple to treat, it only requires hydrating yourself with fresh and clean water. However, your local water source is so contaminated that you do not have access to clean water, and drinking the polluted water from the tap only worsens your symptoms.\n\n");
		System.out.println("Unfortunately, at the age of 44, you passed away from dehydration due to Cholera...\n\n");
		System.out.println("The end...\n\n");
		quiz1();
	}
	public static void quiz1() {
		int count=0;
		System.out.println("We are sorry that you died an unpeaceful death, but we do want to inform you of the reason of your death.\n\n");
		System.out.println("Your reason of death was cholera, a disease that can be spread by contaminated water. Symptoms of cholera includes diarrhea, vomitting, and restlessness (which you are probably familiar with). Read this article on cholera to know more about the reason to your death: https://www.cdc.gov/cholera/illness.html\n\n");
		System.out.println("Now you know a lot more about the disease that caused your death, let's test your understanding.\n\n");
		System.out.println("Q1. 1 in __ people has the luck to experience severe cholera symptoms like you.");
		if(s.nextLine().equals("10")) {
			count++;
			System.out.println("Great job!\n\n");
		}
		else {
			System.out.println("The right answer is: 10\n\n");
		}
		System.out.println("Q2. What was the main effect of severe dehydration that killed you?\n");
		System.out.println("a. Seizure\n");
		System.out.println("b. Low blood volume shock(hypovolemic shock)\n");
		System.out.println("c. Kidney Failure\n");
		if(s.nextLine().equals("c")) {
			count++;
			System.out.println("Great job!\n\n");
		}
		else {
			System.out.println("The right answer is: c. Kidney Failure\n\n");
		}
		System.out.println("Q3. True or False, cholera cannot be spread by physical contact.\n");
		if(s.nextLine().equals("False")) {
			count++;
			System.out.println("Great job!\n\n");
		}
    else if(s.nextLine().equals("false")){
      count++;
			System.out.println("Great job!\n\n");
    }
		else {
			System.out.println("The right answer is: False");
		}
		if(count>1) {
			System.out.println("Your understanding of cholera is decent, good job!");
		}
		else {
			System.out.println("I think you need more practice, maybe read this again: https://www.cdc.gov/cholera/illness.html");
		}
		end();
	}
	public static void pick() {
		System.out.println("You decide to hear what your aunt has to say, because why not? \n\n");
		System.out.println("...beep...\n");
		System.out.println("'"+name+", come over tomorrow to our house at 8 in the morning sharp, alright?'\n");
		System.out.println("You: Why...?\n");
		System.out.println("'For grandpa's funeral. We will go together as a family to church at 8, so please be on time.'\n");
		System.out.println("You: Grandpa? When did that happen? He only just moved into this town months ago.\n");
		System.out.println("'Yes we realized that it was a bad decision to invite him over. The water quality here...you know...not the best for someone that old'\n");
		System.out.println("'Anyways, just be there for grandpa will you? You were his favorite grandchildren...'\n");
		System.out.println("Then your aunt proceeds to rant about the past when your grandpa was still alive and well, but you are too shocked to listen carefully. It only just occured to you that the contaminate water in your town can actually be deadly.\n\n");
		System.out.println("Now that you know that, you decide to...\n\n");
		System.out.println("a. Ignore. Although you grief for your grandpa's death, you don't think you can do anything about it.\n");
		System.out.println("b. Research about what is causing your town's lake to be so polluted.\n");
		System.out.println("c. Move out of town.\n");
		String input=s.nextLine();
		if(input.equals("a")) research();
		else if(input.equals("b")) ignore();
		else if(input.equals("c")) move();
		else error();
	}
	public static void move() {
		System.out.println("You decide to move out of town right after attending your grandpa's funeral, as long as you are not affected by the polluted water, everything will be fine.\n\n");
		System.out.println("However, all the neighboring towns are also opening up factories, and when you complain to the mayors of those towns, they simply blow it off and call you a anti-industrialization conservative. You do have to agree with them in that without the modern industries in your town and these neighboring towns, your life will not be as easy and convenient as it is now. You wonder if there's a way to keep water quality protected without eliminating the factories.\n\n");
		System.out.println("To study this, you decide to start with...\n\n");
		System.out.println("a. Reading books about how detrimental factories are to the environment.\n");
		System.out.println("b. Study ways to make factories environment-friendly.\n");
		String input=s.nextLine();
		if(input.equals("a")) books();
		else if(input.equals("b")) study();
		else error();
	}
	public static void books() {
		System.out.println("You decide to read books and articles on the negative effects factories have on the environment. Days after days you read tens of hundreds of books regarding the topic, and finally, months later, you feel prepared to plead the case to your town's mayor.\n\n");
		System.out.println("The mayor listened to your criticism on the downside of factories and why all of them should be eliminiated from the town. After your passionate speech ended, he called your ideas irrational and radical and kindly advices you to either just get out of this tonw or stop your insane thoughts.\n\n");
		System.out.println("Knowing that similar things will happen if you try to persuade mayors of neighboring towns, you decide to keep your thoughts to yourself and never bring them up to anyone, especially the mayor...\n\n");
		System.out.println("After that you lived a relatively peaceful life until you died of complications due to the consumption of unclean water, how you wish that the mayor had listened to you.\n\n");
		System.out.println("The end...\n\n");
		quiz2();
	}
	public static void quiz2() {
		System.out.println("You must be wondering why did the mayor refuse to listen to you.\n\n");
		System.out.println("You see, the problem with your idea is, you are chocking the economy of the town, the financial income for the mayor. Obviously, the mayor does not want to harm his own benefits. The only right way towards persuasion unfortunately, is to offer the mayor constructive advices on how to keep the factories AND improve the environment.\n\n");
		System.out.println("Why don't you read the texts suggesting ways to make factories more environment-friendly that you skipped during the game: https://www.beekeeper.io/blog/4-ways-manufacturing-companies-can-go-green/.\n\n");
		System.out.println("If you read the article carefully, you will realize that one of the suggestions can directly help town decrease water pollution and reduce waste produced. This method is called __ Manufacturing.\n");
		if(s.nextLine().equals("circular")) {
			System.out.println("You're right.\n\n");
		}
    else if(s.nextLine().equals("Circular")){
      System.out.println("You're right.\n\n");
    }
    else{
      System.out.println("The correct answer is: circular");
    }
		end();
	}
	public static void study() {
		System.out.println("You decide to study some ways to make factories environment-friendly. One day, as you are scrolling on the internet, you find an article that got you attention: https://www.beekeeper.io/blog/4-ways-manufacturing-companies-can-go-green/.\n\n");
		System.out.println("The idea, circular manufacturing, realy got your attention since the effect of decreasing waste production is exactly what your town needs to improve water quality. Thus, you decide to dig deeper into this: https://www.plataine.com/glossary/what-is-circular-manufacturing/.\n\n");
		System.out.println("After months of studying, you are ready. You shared your studies with the mayor of your town, and he really liked your proposal. Approximately one year later, all the factories in your town adopted the methods of circular manufacturing, and soon the water in your town became observably clear. \n\n");
		System.out.println("Drinking the clean water from your sink, you think you might have revenged for your grandpa and defeated the problem of unclean water in your town.\n\n");
		System.out.println("The end...\n\n");
		he();
	}
	public static void he() {
		System.out.println("Congratulations! You saved the fate of you and your town!");
		end();
	}
	public static void research() {
		System.out.println("For you research, you decided to start with...");
		System.out.println("a. Reading books about how detrimental factories are to the environment.\n");
		System.out.println("b. Study ways to make factories environment-friendly.\n");
		String input=s.nextLine();
		if(input.equals("a")) books();
		else if(input.equals("b")) study();
		else error();
	}
	public static void end() {
		System.out.println("Thank you for playing this game, to make different choices, enter r to restart.");
		if(s.nextLine().equals("r")) {
			System.out.println("Remember to make wise choices\n\n");
			start();
		}
		else {
			System.exit(0);
		}
	}
	public static void take() {
		System.out.println("Boss of a company, how cool! You decide to take up your new role and just go with it. \n\n");
		System.out.println("Arriving at the company, the first thing you did was opening up your email. Most of the new mails you received were spam mails, but two caught your attention. The first one is from your sales manager, and the other is from an anonymous email address.\n\n");
		System.out.println("Deciding to address work emails first, you open the one sent by your sales manager. In it, your sales manager suggest you should increase production at all cause since your company's product is becoming popular and the demands are going high. He also further proposes to increase the size of the factory.\n\n");
		System.out.println("Agreeing with every single word the first email said, you open the second email out of curiosity. The anonymous email is way longer than the first one, and it took you a long time to finish it. Amidst the indignant swear words and curses, you deduce that this email is asking you to shut down your factory because it is polluting the town's water by its waste production. The email, with great anger and grief, complains about how the writer of this email's daughter went inside the hospital for complications of consuming unsanitary water yesterday.\n\n");
		System.out.println("You shivered at the email that curses not only your company, you, but also your entire extended family and even your golden retriver. These two emails are asking the exact opposite, which one should you listen to?");
		System.out.println("a. The first, you need to increase supply to meet the increasing demand.\n");
		System.out.println("b. The second, and face potential bankruptcy from too low of a supply.\n");
		String input=s.nextLine();
		if(input.equals("a")) first();
		else if(input.equals("b")) second();
		else error();
	}
	public static void first() {
		System.out.println("You thought of the number of mouths you need to feed at home, and you just cannot afford to shut down your factory for an angry email. Certainly, you feel bad for the daughter who went to the hospital, but if you don't make profit off your products, your whole family will starve on the streets soon.\n\n");
		System.out.println("You expanded the factory, and sure enough, sales doubled. You were able to move to a bigger, newer house with your parents and buy your mom her favorite rice cooker as her birthday present.\n\n");
    System.out.println("However, you are also getting more and more  mails regarding their lives and how they are negatively harmed by the factory's pollution of the water. You feel sad and conflicted about the situation, thus you decided to...\n\n");
    System.out.println("a. Lower the supply, you are feeling too much guilt to carry on.\n");
    System.out.println("b. Stop checking those mail, you feel bad but the well-beings of those unrelated to you are not as important as those closest to you.\n");
    String input=s.nextLine();
		if(input.equals("a")) lower();
		else if(input.equals("b")) stop();
		else error();
	}
  public static void lower(){
    System.out.println("Out of sheer guilt you decided to discontinue the increased production of your factory and soon resigned from your job. Luckily, since you already profited from years of profit, your family can live off the money you've earned before.\n\n");
    System.out.println("After the news of your resignation spread around the town, many of those who sent you hate mails appreciated your choices. However, you have also heard that people believe you are one of the exceptions and the other factories that are damaging the town's water source will not stop like yours.\n\n");
    System.out.println("Realizing this, you decided to:\n");
    System.out.println("a. Set it aside, you already did your part and you can't just force other factory owners to give up what they owned like you.\n");
    System.out.println("b. See what you can do about this.\n");
    String input=s.nextLine();
		if(input.equals("a")) aside();
		else if(input.equals("b")){
      System.out.println("You realized that you can either:\n");
      System.out.println("a. Reading books about how detrimental factories are to the environment.\n");
  		System.out.println("b. Study ways to make factories environment-friendly.\n");
  		String input2=s.nextLine();
  		if(input2.equals("a")) books();
  		else if(input2.equals("b")) study();
  		else error();
    }
		else error();
  }
  public static void aside(){
    System.out.println("Having worked as the owner of your former business for ten years already, you are done with working and just want to stay with your family. You decide to live a life of playing golf with your friends and reading magazines with family daily without doing any work. Maybe you will have fun forever until you pass away peacefully at the age of eighty or ninety...\n\n");
		System.out.println("However, things don't always go the way you wish they will go. At the age of 43, you suddenly develope diarrhoea. You had this issue as a kid, so at first you do not think much of it. However, as time goes on your diarrhoea does not seem to get better. Weeks after weeks you have to sat on the toilet for hours after hours, and even worse, you started vomitting and lossing sleep.\n\n");
		System.out.println("You finally become scared and decide to go to local hospital in your town. The doctos give you some diagnosis and conclude that you have been infected with cholera.\n\n");
		System.out.println("Panicked, you plead the doctors to save you. Cholera should be relatively simple to treat, it only requires hydrating yourself with fresh and clean water. However, your local water source is so contaminated that you do not have access to clean water, and drinking the polluted water from the tap only worsens your symptoms.\n\n");
		System.out.println("Unfortunately, at the age of 44, you passed away from dehydration due to Cholera...\n\n");
		System.out.println("The end...\n\n");
		quiz1();
  }
  public static void stop(){
    System.out.println("You stop checking those hate mails so you can focus upon earning money for your family. Your parents paid for the first half of your life and now you feel obligated to give them the best lives possible.\n\n");
    System.out.println("...Your parents lived the rest of their lives at peace. You thought you would too, living at till the age of eighty or ninety...\n\n");
    System.out.println("However, things don't always go the way you wish they will go. At the age of 43, you suddenly develope diarrhoea. You had this issue as a kid, so at first you do not think much of it. However, as time goes on your diarrhoea does not seem to get better. Weeks after weeks you have to sat on the toilet for hours after hours, and even worse, you started vomitting and lossing sleep.\n\n");
		System.out.println("You finally become scared and decide to go to local hospital in your town. The doctos give you some diagnosis and conclude that you have been infected with cholera.\n\n");
		System.out.println("Panicked, you plead the doctors to save you. Cholera should be relatively simple to treat, it only requires hydrating yourself with fresh and clean water. However, your local water source is so contaminated that you do not have access to clean water, and drinking the polluted water from the tap only worsens your symptoms.\n\n");
		System.out.println("Unfortunately, at the age of 44, you passed away from dehydration due to Cholera...\n\n");
		System.out.println("The end...\n\n");
		quiz1();
  }
  public static void second(){
    System.out.println("You felt so guilty after reading that mail you decide to not increase production. You decide to:\n");
    System.out.println("a. Close your factory as a whole to eliminate pollution caused by it.\n");
    System.out.println("b. Hold up, investigate a bit.\n");
    String input=s.nextLine();
    if(input.equals("a")) close();
		else if(input.equals("b")){
      System.out.println("You soon realized that you can either:\n");
      System.out.println("a. Reading books about how detrimental factories are to the environment.\n");
  		System.out.println("b. Study ways to make factories environment-friendly.\n");
  		String input2=s.nextLine();
  		if(input2.equals("a")) books();
  		else if(input2.equals("b")) study();
  		else error();
    }
		else error();
  }
  public static void close(){
    System.out.println("With the factory closed, your company is definitely going down. This was fine at first since you had deposit from before, but everything changed after that one day.\n\n");
    System.out.println("The bank where your money was kept in went bankrupt, and without steady income made by you, your family is soon running low financially since both your parents are too old to work.\n\n");
    System.out.println("You had to sell your house, rent the cheapest apartment where you and your parents squeezed in. Your parents always supported what you did, but you will forever feel guilty about this.\n\n");
    System.out.println("...Your parents both passed away in the span of two years, and your world was shattered. You think of yourself as the worst child ever because you could not offer your parents what they deserved. This guilt and shame followed you throughout the years, and it hindered your ability to socialize. When you left the world, you left no one and nothing meaningful behind...\n\n");
    quiz3();
  }
  public static void quiz3(){
    System.out.println("You see, it is not always fair to require companies to close down factories because the closing of factories means potential bankruptcy for the company and its owners and managers. There are definitely more sustainable ways of alleviating the pressure upon the environment while still allowing companies to keep their factories. Read: https://www.beekeeper.io/blog/4-ways-manufacturing-companies-can-go-green/");
    System.out.println("If you read the article carefully, you will realize that one of the suggestions can directly help town decrease water pollution and reduce waste produced. This method is called __ Manufacturing.\n");
		if(s.nextLine().equals("circular")) {
			System.out.println("You're right.\n\n");
		}
    else if(s.nextLine().equals("Circular")){
      System.out.println("You're right.\n\n");
    }
    else{
      System.out.println("The correct answer is: circular");
    }
    end();
  }
	public static void error() {
		System.out.println("Wrong key typed");
	}
  public static void main(String[] args){
    quiz1();
  }
}

