
public class WTspongeListener extends PluginListener{
	boolean rlsponge;
	int rad;
	public void props(){
		PropertiesFile f = new PropertiesFile("WTsponge.properties");
		rlsponge = f.getBoolean("Real-Life-Sponge",false);
		rad = f.getInt("Sponge-Radius",2);
	}
	public boolean onBlockCreate(Player player,Block block,Block blockClicked,int itemInHand){
		if (player.canUseCommand("/usesponge")){
			if (block != null){
			int type = block.getType();
		if (type == 19){
			if (rlsponge == false){
				airout(block,rad);
				return false;
			}
		}
		}
		return false;
		}
		return false;
	}
	
	
	public boolean onBlockDestroy(Player player,Block block){
		if (block.getType() == 19 && player.canUseCommand("/usesponge")){
			if (rlsponge == false){
			replacewater(block,rad);
			return false;
			}
		}
		return false;
	}
	
	public boolean onFlow(Block blockFrom,Block blockTo){
		if (blockFrom.getType() == 8 || blockFrom.getType() == 9){
			if (isinarea(blockFrom,rad)&& !isinarea2(blockFrom,rad)){
				return true;
			}
			}
		return false;
	}
	
	public boolean onBlockRightClick(Player player,Block block,Item itemInHand){
		if (block.getType() == 19 && player.canUseCommand("/usesponge")){
			if (rlsponge){
				if(iswater(block, rad)){
					airout(block,rad);
					return false;
				}else{
					fillarea(block,rad);
					return false;
				}
			}
			return false;
		}
		return false;
	}
	public void airout(Block b, int radius){
		int xmin = (int)b.getX()-radius;
		int xmax = (int)b.getX()+radius;
		int ymin = (int)b.getY()-radius;
		int ymax = (int)b.getY()+radius;
		int zmin = (int)b.getZ()-radius;
		int zmax = (int)b.getZ()+radius;
		for (int x = xmin; x <= xmax; x++) {
			for (int y = ymin; y <= ymax; y++) {
				for (int z = zmin; z <= zmax; z++) {
					if (b.getWorld().getBlockAt(x, y, z).getType() == 8 || b.getWorld().getBlockAt(x, y, z).getType() == 9){b.getWorld().setBlockAt(0, x, y, z);}
				}
			}
		}
	  }
	public void fillarea(Block b, int radius){
		int xmin = (int)b.getX()-radius;
		int xmax = (int)b.getX()+radius;
		int ymin = (int)b.getY()-radius;
		int ymax = (int)b.getY()+radius;
		int zmin = (int)b.getZ()-radius;
		int zmax = (int)b.getZ()+radius;
		for (int x = xmin; x <= xmax; x++) {
			for (int y = ymin; y <= ymax; y++) {
				for (int z = zmin; z <= zmax; z++) {
					if (b.getWorld().getBlockAt(x, y, z).getType() == 0){b.getWorld().setBlockAt(9, x, y, z);}
				}
			}
		}
	  }
	public void replacewater(Block b, int radius){
		int radi = radius+1;
		int xmin = (int)b.getX()-radi;
		int xmax = (int)b.getX()+radi;
		int ymin = (int)b.getY()-radi;
		int ymax = (int)b.getY()+radi;
		int zmin = (int)b.getZ()-radi;
		int zmax = (int)b.getZ()+radi;
		for (int x = xmin; x <= xmax; x++) {
			for (int y = ymin; y <= ymax; y++) {
				for (int z = zmin; z <= zmax; z++) {
					if (b.getWorld().getBlockAt(x, y, z).getType() == 8 || b.getWorld().getBlockAt(x, y, z).getType() == 9){b.getWorld().setBlockAt(8, x, y, z);}
				}
			}
		}
	  }
	public boolean isinarea(Block b,int radius){
		int radi = radius+1;
		int xmin = (int)b.getX()-radi;
		int xmax = (int)b.getX()+radi;
		int ymin = (int)b.getY()-radi;
		int ymax = (int)b.getY()+radi;
		int zmin = (int)b.getZ()-radi;
		int zmax = (int)b.getZ()+radi;
		for (int x = xmin; x <= xmax; x++) {
			for (int y = ymin; y <= ymax; y++) {
				for (int z = zmin; z <= zmax; z++) {
					if (b.getWorld().getBlockAt(x, y, z).getType() == 19){return true;}
				}
			}
		}
		return false;
	}
	
	public boolean isinarea2(Block b,int radius){
		int radi = radius;
		int xmin = (int)b.getX()-radi;
		int xmax = (int)b.getX()+radi;
		int ymin = (int)b.getY()-radi;
		int ymax = (int)b.getY()+radi;
		int zmin = (int)b.getZ()-radi;
		int zmax = (int)b.getZ()+radi;
		for (int x = xmin; x <= xmax; x++) {
			for (int y = ymin; y <= ymax; y++) {
				for (int z = zmin; z <= zmax; z++) {
					if (b.getWorld().getBlockAt(x, y, z).getType() == 19){return true;}
				}
			}
		}
		return false;
	}
		public boolean iswater(Block b, int radius){
			int xmin = (int)b.getX()-radius;
			int xmax = (int)b.getX()+radius;
			int ymin = (int)b.getY()-radius;
			int ymax = (int)b.getY()+radius;
			int zmin = (int)b.getZ()-radius;
			int zmax = (int)b.getZ()+radius;
			for (int x = xmin; x <= xmax; x++) {
				for (int y = ymin; y <= ymax; y++) {
					for (int z = zmin; z <= zmax; z++) {
						if (b.getWorld().getBlockAt(x, y, z).getType() == 8 || b.getWorld().getBlockAt(x, y, z).getType() == 9){return true;}
					}
				}
			}
		return false;
	  }
}
