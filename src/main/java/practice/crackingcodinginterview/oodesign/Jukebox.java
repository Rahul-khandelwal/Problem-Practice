/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.crackingcodinginterview.oodesign;

import java.util.*;

/**
 * Design a musical jukebox using object oriented priciples.
 */

/**
 * Here we need to clarify some constraints - 
 * 1. What does this jukebox plays: CDs?, Records? or MP3s?
 * 2. Is it a simulation on computer or does this represents a physical jukebox ?
 * 3. Is it paid or free ?
 * 4. If it is paid then what is the currency and does it return change ?
 */

/**
 * Assumptions - 
 * Jukebox is computer simulation and it's free.
 */

/**
 * Basic system components - 
 * Jukebox
 * CD
 * Song
 * Artist
 * Playlist
 * Display (displays details on screen)
 */

/**
 * Possible actions - 
 * Playlist creation (can include add, delete and shuffle)
 * CD selector
 * Song selector
 * Queuing up a song
 * Get next song from playlist
 * 
 * User can be introduced and possible actions can be - 
 * add, delete and credit information
 */

/**
 * Represents a CD.
 */
class CD {
    /**
     * Data for id, artist, song, etc.
     */
}

/**
 * Represents a song.
 */
class Song {
    /**
     * Data for id, CD (could be null), title, length, etc.
     */
}

/**
 * Represents a user.
 */
class User {
    private String name;
    private long id;

    public User(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public static User addUser(String _name, long _id) {
        return new User(_name, _id);
    }
}

/**
 * This class manages current and next songs to play.
 * This is a wrapper for song queue and offers some additional functionality.
 */
class Playlist {
    private Song currSong;
    private Queue<Song> queue;

    public Playlist(Song currSong, Queue<Song> queue) {
        this.currSong = currSong;
        this.queue = queue;
    }
    
    public Song getNextSongToPlay() {
        return queue.peek();
    }
     
    public void queueUpSong(Song _song) {
        this.queue.add(_song);
    }
}

/**
 * Stores just one CD at a time.
 * CDs that are not in play are stored in jukebox.
 */
class CDPlayer {
    private Playlist playlist;
    private CD cd;

    public CDPlayer(Playlist playlist, CD cd) {
        this.playlist = playlist;
        this.cd = cd;
    }

    public CDPlayer(Playlist playlist) {
        this.playlist = playlist;
    }

    public CDPlayer(CD cd) {
        this.cd = cd;
    }
    
    public void playSong(Song _song) {
        // play the song
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public CD getCd() {
        return cd;
    }

    public void setCd(CD cd) {
        this.cd = cd;
    }
}

/**
 * This class is the main body of the problem.
 * Most of the interaction between components are channeled through here.
 * 
 * @author Rahul
 */
public class Jukebox {
    private CDPlayer player;
    private User user;
    private Set<CD> collection;
    // we could also have one song selector

    public Jukebox(CDPlayer player, User user, Set<CD> collection) {
        this.player = player;
        this.user = user;
        this.collection = collection;
    }
    
    public Song getCurrentSong() {
        return this.player.getPlaylist().getNextSongToPlay(); //  or use the song selector
    }

    public void setUser(User user) {
        this.user = user;
    }
}
