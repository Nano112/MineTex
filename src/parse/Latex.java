
public class Latex //C'est pas du Latex Faudras changer de nom je pense

{
     /*
     HOWTO:

     Chaque élément de base a une taille (Bounding Box) par défault.
     Lorsque que l'on parse le code Latex, on aura un arbre avec des lettres et des chiffres en tant que feuilles
     et des symboles/opérand en tant que noeuds.
     Chaque Operand et symbole a des conditions sur la taille (pour \sum_{k=1}^{n}{f(k)} il faut que la taille de k=1 et de n soit inférieure à f(k) -> D'ou le sizeClass.
     (sizeClass = hauteur du caratère? )
     -On remonte l'arbre, en adjustant les bounding box pour que l'expression soit 'esthétique':
        exemple: 1+\sqrt{\frac{3}{5}}
          --> la sizeClass de \sqrt{\frac{3}{5}} sera plus grande que la sizeClass de sqrt{\frac{3}{5}} -> On augment la size class de 1 pour qu'elle y soit égale.
           (Il faut aussi faire attention pour la largeur en (x) ?) (Exemple \sum_{k=f(1+\sqrt{4})}{k} les caractères s'intersecteraient)



     TODO:
     lettres: maj, min, grecques maj, grecques min.
     chiffres,
     symboles: +, -, x, !, (, )
     Opérand: lim, d/dx, intégrale, fraction, racine

     Osef du calcul tensoriel? (vecteur, le \bar?, produit contracté, matrices)
     ^
     Pendant qu'on y est oui mais deja faut avoir les operations de base plus des trucs moin basique comme des sommes
      
     Parser
     Toutes les tiles 
     TileReader
     Render
     SizeManager 
     parse.ExpressionTree

*/

}
