	import java.util.logging.Logger;
public class WTsponge extends Plugin{
	  String name = "WTsponge ";
	  String version = "1.0 ";
	  String author = "by spenk ";
	  static Logger log = Logger.getLogger("Minecraft");

	  public void initialize()
	  {
		  WTspongeListener listener = new WTspongeListener();
	    log.info(this.name + " version " + this.version + " by " + this.author + " is initialized!");
	    etc.getLoader().addListener(PluginLoader.Hook.BLOCK_CREATED, listener, this, PluginListener.Priority.MEDIUM);
	    etc.getLoader().addListener(PluginLoader.Hook.BLOCK_DESTROYED, listener, this, PluginListener.Priority.MEDIUM);
	    etc.getLoader().addListener(PluginLoader.Hook.BLOCK_RIGHTCLICKED, listener, this, PluginListener.Priority.MEDIUM);
	    etc.getLoader().addListener(PluginLoader.Hook.FLOW, listener, this, PluginListener.Priority.MEDIUM);
	    listener.props();
	  }

	  public void enable() {
	    log.info(this.name + " version " + this.version + " by " + this.author + " is enabled!");
	  }

	  public void disable() {
	    log.info(this.name + " version " + this.version + " is disabled!");
	  }
}
