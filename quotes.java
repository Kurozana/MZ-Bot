package Bot;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class quotes extends ListenerAdapter {

    String [] msgs = {
            "[member] ماتحس السستم يبيله ؟",
            "Just another person from this lovely world, don't you think [member] ? uwu",
            "[member] كذاب والله اني كيوت وحلو وكلامك مردود عليه",
            "[member] ولاااااااااااااي",
            "[member] اص يا قواد",
            "[member] يلا ليق؟",
            "[member] يوووووووه شوفو شلون يقولها القواد زي الفيم بوي ههااااااااي اواووووووو",
            "[member] كأنك تينيس نفسيه",
            "شالسالفه حبي؟",
            "اخخخ يا wolfie",
            "ليق تجيك فنانه ولا ",
            "سيت داون ولك",
            "هاااه شتبي",
            "بالله كلم العيال حنا 4 حلوين ناقصنا 1 وننزل كلاش",
            "اح كأنك عمار ملك التعابين",
            "جداوي هو ؟",
            "مالي خلقك ياواد",
            "يلا؟",
            "شرايك بتينيس?",
            "صباحوووو",
            "شوف كلم ابراهيم يضيف لنا جمله ولا جملتين خلنا نعرف نتكلم",
            "اح",
            "يسعده",
            "كل زق يالشيوعي",
            "روح عالمي",




    };

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String [] args = event.getMessage().getContentRaw().split("\\s+");
        Random rand = new Random();
        int num = rand.nextInt(msgs.length);
     if(args[0].equalsIgnoreCase("n3ia") || args[0].equalsIgnoreCase("نعيه")){
         event.getChannel().sendMessage(msgs[num].replace("[member]", event.getMember().getAsMention())).queue();
     }
    }
}


