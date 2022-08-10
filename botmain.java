package Bot;
import kotlin.random.Random;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManager;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;
import java.util.Locale;


public class BotMain {

    private final ShardManager SM;
    public BotMain() throws LoginException{
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault("NTM1Mjg3ODUxMzE5OTUxMzk5.GbR6w1.9TJ0kMdjL6BqMe16LaGNg0S4uQEkp5WZtsuKpI");
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("Femboys dance"));
        SM = builder.build();

    }

    public ShardManager getSM() {
        return SM;
    }

    public static void main(String[] args) {
        try {
            BotMain bot = new BotMain();
        } catch (LoginException e) {

        }
    }
}
