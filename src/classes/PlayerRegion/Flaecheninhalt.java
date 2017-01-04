package classes.PlayerRegion;

import org.bukkit.entity.Player;

public class Flaecheninhalt {

	public static int xZahl = 0;
	public static int zZahl = 0;
	public static int gesammt = 0;
	
	public static void flaecheninhaltX(Player p, int x1, int x2) {

		if (x1 < 0 && x2 < 0) {
			/*
			 * 
			 *  Kleiner 0
			 * 
			 */
			if (x1 > x2) {
				int gesammt = x1 - x2;
				Flaecheninhalt.xZahl = gesammt;
			} else {
				int gesammt = x2 - x1;
				Flaecheninhalt.xZahl = gesammt;
			}
			
			/*
			 * 
			 *  Größer 0
			 * 
			 */
		} else if (x1 > 0 && x2 > 0) {
			if(x1 < x2) {
				int gesammt = x2 - x1;
				Flaecheninhalt.xZahl = gesammt;
				
			} else {
				int gesammt = x1 - x2;
				Flaecheninhalt.xZahl = gesammt;
			}
			
			/*
			 * 
			 *  Größer 0 Kleiner 0
			 * 
			 */
		} else if (x1 > 0 && x2 < 0) {
			int gesammt = x1 - x2;
			Flaecheninhalt.xZahl = gesammt;
			
			
			/*
			 * 
			 * Kleiner 0 Größer 0
			 * 
			 */
		} else if(x1 < 0 && x2 > 0) {
			int gesammt = x2 + x1;
			Flaecheninhalt.xZahl = gesammt;
		}
	}
		
		
		public static void flaecheninhaltZ(Player p, int z1, int z2) {

			if (z1 < 0 && z2 < 0) {
				/*
				 * 
				 *  Kleiner 0
				 * 
				 */
				if (z1 > z2) {
					int gesammt = z1 - z2;
					Flaecheninhalt.zZahl = gesammt;
				} else {
					int gesammt = z2 - z1;
					Flaecheninhalt.zZahl = gesammt;
				}
				
				/*
				 * 
				 *  Größer 0
				 * 
				 */
			} else if (z1 > 0 && z2 > 0) {
				if(z1 < z2) {
					int gesammt = z2 - z1;
					Flaecheninhalt.zZahl = gesammt;
				} else {
					int gesammt = z1 - z2;
					Flaecheninhalt.zZahl = gesammt;
				}
				
				/*
				 * 
				 *  Größer 0 Kleiner 0
				 * 
				 */
			} else if (z1 > 0 && z2 < 0) {
				int gesammt = z1 - z2;
				Flaecheninhalt.zZahl = gesammt;
				
				
				/*
				 * 
				 * Kleiner 0 Größer 0
				 * 
				 */
			} else if(z1 < 0 && z2 > 0) {
				int gesammt = z2 + z1;
				Flaecheninhalt.zZahl = gesammt;
			}
		
	}		
		

		public static int Zusammen(Player p, int x1, int x2, int z1, int z2) {
			Flaecheninhalt.flaecheninhaltX(p, x1, x2);
			Flaecheninhalt.flaecheninhaltZ(p, z1, z2);
			int gesammt = (Flaecheninhalt.zZahl + 1) * (Flaecheninhalt.xZahl + 1);
			return Flaecheninhalt.gesammt = gesammt;
		}
}
