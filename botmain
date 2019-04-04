package Bot;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

public class BotMain{

    public static String PFX = "-";

    public static void main(String[]args) throws Exception{
        try {
            JDA api = new JDABuilder(AccountType.BOT).setToken("NTM1Mjg3ODUxMzE5OTUxMzk5.DyHdLQ.VTuNf8g5kbdnLg0sF9W7XJ6xd14").build();
            api.addEventListener(new Bot.MyEventListener());
            api.addEventListener(new InviteCommand());
            api.addEventListener(new Mj());
            api.addEventListener(new ML());
            api.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
            api.getPresence().setGame(Game.listening("Homework Radio on YT"));



        }catch (Exception ex){
            ex.printStackTrace();
        }


    }


}
