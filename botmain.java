package Bot;
import Bot.Listeners.EventListener;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;


public class BotMain {
    private final Dotenv config;
    private final ShardManager SM;

    public BotMain() throws LoginException{
        config = Dotenv.configure().load();
        String token =  config.get("TOKEN");

        // Builder & Shard Manager
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setActivity(Activity.watching("Femboys dance"));
        SM = builder.build();
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.setChunkingFilter(ChunkingFilter.ALL);
        builder.enableCache(CacheFlag.ACTIVITY, CacheFlag.MEMBER_OVERRIDES, CacheFlag.ONLINE_STATUS);




        // Register Listeners here :)
        SM.addEventListener(new EventListener());

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
