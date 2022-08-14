package Bot;
import io.github.cdimascio.dotenv.Dotenv;
import kotlin.random.Random;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManager;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;
import java.util.Locale;


public class BotMain {
    private final Dotenv config;
    private final ShardManager SM;
    public BotMain() throws LoginException{
    config = Dotenv.configure().load();
    String token =  config.get("TOKEN");

        // Building the ShardManager
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("Femboys dance"));
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MESSAGE_TYPING, GatewayIntent.GUILD_MEMBERS);

        SM = builder.build();
        SM.addEventListener(new Actions());

    }

    public Dotenv getConfig(){
        return config;
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
