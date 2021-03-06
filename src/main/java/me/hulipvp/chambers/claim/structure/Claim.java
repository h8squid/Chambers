package me.hulipvp.chambers.claim.structure;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.hulipvp.chambers.team.structure.Team;

@AllArgsConstructor
@Getter
public class Claim {
	
	private Location cornerOne, cornerTwo;
	
	private Team owner;
	
	/**
	 * Returns <tt>true</tt> if the provided Location is inside the claim.<br>
	 * However, it returns <tt>false</tt> if the provided Location is not inside the claim
	 * 
	 * @param location - the Location in which you wish to see is inside the claim
	 * @return boolean - Whether or not the provided Location is inside the claim or not
	 */
	public boolean isInsideClaim(Location location) {
		return (location.getX() >= Math.min(cornerOne.getX(), cornerTwo.getX()))
				&& (location.getZ() >= Math.min(cornerOne.getZ(), cornerTwo.getZ()))
				&& (location.getX() <= Math.max(cornerOne.getX(), cornerTwo.getX()))
				&& (location.getZ() <= Math.max(cornerOne.getZ(), cornerTwo.getZ()));
	}
	
	/**
	 * Returns <tt>true</tt> if the Player's location is inside the claim.<br>
	 * However, it returns <tt>false</tt> if the Player's location is not inside the claim
	 * <p>
	 * It's just a faster way instead of doing {@link isInsideClaim(player.getLocation)}, cuz
	 * I'm just that lazy
	 * 
	 * @param player - the Player in which you wish to see is inside the claim
	 * @return boolean - Whether or not the player's location is inside the claim or not
	 */
	public boolean isInsideClaim(Player player) {
		return isInsideClaim(player.getLocation());
	}

}
