package com.romedawg.rome.Domain;


import javax.persistence.*;

@Entity()
@Table(name="catalog")
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;
    private String artist;
    private String album;

//    public Album(String name){
//            this.album = album;
//    }

    public Catalog() {
    }

    public Catalog(String artist, String album) {
        this.album = album;
        this.artist = artist;
    }

//    @Override
//    public String toString() {
//        return "Album{" +
//                ", artist='" + artist + '\'' +
//                ", album='" + album + '\'' +
//                '}';
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
